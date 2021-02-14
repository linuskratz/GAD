/**
 * Die Klasse RingQueue soll eine zirkuläre Warteschlange auf Basis der Klasse
 * {@link DynamicArray} implementieren.
 */
public class RingQueue {
	private DynamicArray dynArr;

	private int size;
	private int from;
	private int to;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Dieser Konstruktor erzeugt eine neue Ringschlange. Ein leere Ringschlange
	 * habe stets eine Größe von 0, sowie auf 0 gesetzte Objektvariablen to und
	 * from.
	 * 
	 * @param growthFactor der Wachstumsfaktor des zugrundeliegenden dynamischen
	 *                     Feldes
	 * @param maxOverhead  der maximale Overhead des zugrundeliegenden dynamischen
	 *                     Feldes
	 */
	public RingQueue(int growthFactor, int maxOverhead) {
		dynArr = new DynamicArray(growthFactor, maxOverhead);
		size = 0;
		from = 0; // erstes
		to = 0; // erster freie
	}

	/**
	 * Diese Methode reiht ein Element in die Schlange ein.
	 * 
	 * @param value der einzufügende Wert
	 */
	public void enqueue(int value) {
		Interval newI = dynArr.reportUsage(new NonEmptyInterval(from, to), ++size);
		from = newI.getFrom();
		to = newI.getTo();
		if (size != 1)
			to = (to + 1) % dynArr.getInnerLength();
		dynArr.set(to, value);
	}

	/**
	 * Diese Methode entfernt ein Element aus der Warteschlange.
	 * 
	 * @return das entfernte Element
	 */
	public int dequeue() {
		int ret = dynArr.get(from);
		if (size != 0)
			from = (from + 1) % dynArr.getInnerLength();
		size--;
		Interval newI = dynArr.reportUsage(new NonEmptyInterval(from, to), size);
		from = newI.getFrom();
		to = newI.getTo();
		return ret;
	}

	public String toString() {
		return dynArr + ", size: " + size + ", from " + from + " to " + to;
	}
}
