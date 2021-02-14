
public class Test {
	public static void main(String[] args) {
		RingQueue ringQueue = new RingQueue(4, 8);
		ringQueue.enqueue(1);
		System.out.println(ringQueue);
		ringQueue.dequeue();
		System.out.println(ringQueue);
		ringQueue.enqueue(0);;
		System.out.println(ringQueue);
		// [], length: 0, [], length: 0 
		// [4, 0, 0, 0], length: 1, [], length: 0
		// [4, 1, 0, 0], length: 2, [], length: 0
		// [4, 1, 5, 0], length: 3, [], length: 0
		// [4, 1, 5, 6], length: 4, [], length: 0 
		// [], length: 0, [6, 5, 1, 0], length: 3 
		// [], length: 0, [6, 5, 0, 0], length: 2 
		// [2, 0, 0, 0], length: 1, [6, 5, 0, 0], length: 2
		// [2, 0, 0, 0], length: 1, [6, 0, 0, 0], length: 1
		
		
	}
	

}
