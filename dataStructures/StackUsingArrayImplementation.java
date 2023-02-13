package dataStructures;

public class StackUsingArrayImplementation {

	private int[] arr;
	private int top;
	
	public StackUsingArrayImplementation() {
		arr = new int[10];
		top = -1;
	}
	
	public StackUsingArrayImplementation(int capacity) {
		arr = new int[capacity];
		top = -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public int peek() throws EmptyStackException {
		if(size() == 0) {
			//EmptyStackException
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		return arr[top];
	}
	
	public int pop() throws EmptyStackException {
		if(size() == 0) {
			//EmptyStackException
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		int temp = arr[top];
		arr[top] = 0;
		top--;
		return temp;
	}
	
	public void push(int e) {
		if(top == arr.length-1) reEvaluate();
		
		top++;
		arr[top] = e;
	}
	
	public void reEvaluate() {
		int[] arr2 = new int[arr.length * 2];
		
		for(int i=0; i<arr.length; i++) {
			arr2[i] = arr[i];
		}
		
		arr = arr2;
	}

}
