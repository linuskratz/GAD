public class BinomialTreeNode {
	private BinomialTreeNode[] children;
	private int rank; // jeder teilbaum hat genau x kinder
	private int min;

	public BinomialTreeNode(int key) {
		this.min = key;
		this.rank = 0;
		children = new BinomialTreeNode [0];
	}

	/**
	 * Ermittelt das minimale Element im Teilbaum.
	 *
	 * @return das minimale Element
	 */
	public int min() {
		return min;
	}

	/**
	 * Gibt den Rang des Teilbaumes zurück.
	 *
	 * @return der Rang des Teilbaumes
	 */
	public int rank() {
		return rank;
	}

	/**
	 * Entfernt den minimalen Knoten (= Wurzel) und gibt eine Menge von
	 * Teilbäumen zurück, in die der aktuelle Baum zerfällt, wenn man
	 * den Knoten entfernt.
	 *
	 * @return die Menge von Teilbäumen
	 */
	public BinomialTreeNode[] deleteMin() {
		return children;
	}

	/**
	 * Diese Methode vereint zwei Bäume des gleichen Ranges.
	 *
	 * @param a der erste Baum
	 * @param b der zweite Baum
	 * @return denjenigen der beiden Bäume, an den der andere angehängt wurde
	 */
	public static BinomialTreeNode merge(BinomialTreeNode a, BinomialTreeNode b) {
		BinomialTreeNode [] interim = new BinomialTreeNode [a.children.length +1];
		if (a.min() > b.min()) {
			System.arraycopy(b.children, 0, interim, 0, b.children.length);
			interim[b.children.length] = a;
			b.children = interim;
			return b;
		}else {
			System.arraycopy(a.children, 0, interim, 0, a.children.length);
			interim[a.children.length] = b;
			a.children = interim;
			return a;
		}
	}
	
	public void setMin(int key) {
		this.min = key;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	private void print(int depth) {
		for(int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.print("[rank: " + rank() + " key: " + min() + "]\n");
		for(BinomialTreeNode c : children) {
			c.print(depth+1);
		}
	}

	/**
	 * Diese Methode gibt den Binomialbaum aus.
	 */
	public void print() {
		print(0);
	}
}
