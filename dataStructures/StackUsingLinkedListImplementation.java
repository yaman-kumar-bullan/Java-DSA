package dataStructures;

public class StackUsingLinkedListImplementation {
	
	private Node<Integer> head;
	private Node<Integer> tail;
	private int top;
	
	public StackUsingLinkedListImplementation() {
		head = null;
		tail = null;
		top = -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	
	public int peek() throws EmptyStackException {
		if(size() == 0) {
			//EmptyStackException
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		return tail.data;
	}
	
	public int pop() throws EmptyStackException {
		if(size() == 0) {
			//EmptyStackException
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		if(head.next == null) {
			int temp = tail.data;
			head = null;
			tail = null;
			top--;
			return temp;
		}
		
		Node<Integer> temp = head;
		
		while(temp.next.next != null) temp = temp.next;
		
		int data = tail.data;
		temp.next = null;
		tail = temp;
		top--;
		return data;
	}
	
	public void push(int e) {
		Node<Integer> newNode = new Node<>(e);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			top++;  //To increase the size
			return;
		} 
		
		tail.next = newNode;
		tail = tail.next;
		top++;
	}

}
