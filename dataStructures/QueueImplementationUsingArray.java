package dataStructures;

public class QueueImplementationUsingArray {
	
	private int[] data;
	private int front, rear, size;
	
	public QueueImplementationUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int front() throws EmptyQueueException {
		if(size==0) {
			throw new EmptyQueueException();
		}
		
		return data[front];
	}
	
	public void enqueue(int e) throws EmptyQueueException {
		if(size == data.length) {
			reStructure();  //This can throw EmptyQueueException
		}
		
		if(size == 0) front = 0;
		
		rear = (rear+1) % data.length;
		size++;
		data[rear] = e;
	}
	
	public int dequeue() throws EmptyQueueException{
		if(size == 0) {
			throw new EmptyQueueException();
		}
		
		int temp = data[front];
		front = (front+1) % data.length;
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	public void reStructure() throws EmptyQueueException {
		int[] newData = new int[data.length * 2];
		int index = 0;
		int queueSize = size;
		
		for(int i=1; i<=queueSize; i++) {
			newData[index++] = dequeue();
		}
		
		data = newData;
		front = 0;
		rear = index-1;
		size = index;
	}

}
