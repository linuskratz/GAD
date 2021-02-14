/**
 * Die Klasse StackyQueue soll eine Warteschlange auf
 * Basis der Klasse {@link DynamicStack} implementieren. Es
 * soll ausschließlich die Klasse {@link DynamicStack} zur
 * Datenspeicherung verwendet werden.
 */
public class StackyQueue {
  DynamicStack enqueueStack;
  DynamicStack dequeueStack;

  /**
   * Diese Methode ermittelt die Länge der Warteschlange.
   * @return die Länge der Warteschlange
   */
  public int getLength() {
    return enqueueStack.getLength() + dequeueStack.getLength();
  }
  
  /**
   * Dieser Kontruktor initialisiert eine neue Schlange.
   * 
   * @param growthFactor
   * @param maxOverhead
   */
  public StackyQueue (int growthFactor, int maxOverhead) {
	  enqueueStack = new DynamicStack(growthFactor,maxOverhead);
	  dequeueStack = new DynamicStack(growthFactor,maxOverhead);
  }
  
  /**
   * Diese Methode reiht ein Element in die Schlange ein.
   * 
   * @param value der einzufügende Wert
   */
  public void enqueue (int value) {
	  enqueueStack.pushBack(value);
  }
  
  /**
   * Diese Methode entfernt ein Element aus der Warteschlange.
   * 
   * @return das entfernte Element
   */
  public int dequeue () {
	  int ret;
	  if (dequeueStack.getLength()==0) {
		  int x = enqueueStack.getLength();
		  for (int i = 0; i<x; i++) {
			  int element = enqueueStack.popBack();
			  dequeueStack.pushBack(element);
		  }
	  }
	  ret = dequeueStack.popBack();
	  return ret;
  }
  
  public String toString() {
	return enqueueStack+ ", "+dequeueStack;
  }
}


