package dataStructures;

public class QueueUsingLLGenericImplementation<T> {
	
	private Node<T> front;  //dequeue
	private Node<T> rear;   //enqueue
	private int size;
	
	public QueueUsingLLGenericImplementation() {
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
	
	public T front() throws EmptyQueueException {
		if(size == 0) {
			throw new EmptyQueueException();
		}
		
		return front.data;
	}
	
	public void enqueue(T e) {
		Node<T> newNode = new Node<>(e);
		
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
	
	public T dequeue() throws EmptyQueueException {
		if(size == 0) throw new EmptyQueueException();
		
		T temp = front.data;
		front = front.next;
		size--;
		
		if(size == 0) {
			front = null;
			rear = null;
		}
		return temp;
	}

}
