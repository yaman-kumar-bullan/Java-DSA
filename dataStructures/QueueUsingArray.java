package dataStructures;

public class QueueUsingArray {
	
	public static void main(String[] args) throws EmptyQueueException {
		
		QueueImplementationUsingArray queue = new QueueImplementationUsingArray();
		
		for(int i=1; i<=20; i++) {
			queue.enqueue(i);
		}
		
		while(! queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
	}
}
