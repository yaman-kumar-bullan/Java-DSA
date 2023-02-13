package dataStructures;

public class QueueImplementationUsingLinkedList {
	
	private Node<Integer> front;  //dequeue
	private Node<Integer> rear;   //enqueue
	private int size;
	
	public QueueImplementationUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int front() throws EmptyQueueException {
		if(size == 0) {
			throw new EmptyQueueException();
		}
		
		return front.data;
	}
	
	public void enqueue(int e) {
		Node<Integer> newNode = new Node<>(e);
		
		if(size == 0) {
			front = newNode;
			rear = newNode;
			size++;
			return;
		}
		
		rear.next = newNode;
		size++;
		rear = rear.next;
	}
	
	public int dequeue() throws EmptyQueueException {
		if(size == 0) throw new EmptyQueueException();
		
		int temp = front.data;
		front = front.next;
		size--;
		
		if(size == 0) {
			front = null;
			rear = null;
		}
		return temp;
	}

}
