package dataStructures;

public class QueueUsingLinkedList {
	
	public static void main(String[] args) throws EmptyQueueException {
		
		QueueImplementationUsingLinkedList queue = new QueueImplementationUsingLinkedList();
		
		for(int i=1; i<=20; i++) {
			queue.enqueue(i);
		}
		
		while(! queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
	}
}
