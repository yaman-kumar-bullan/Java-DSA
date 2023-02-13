package ExceptionHandling;

public class DynamicArray {
	
	private int[] arr;
	private int index;
	
	public DynamicArray() {
		arr = new int[5];
		index = 0;
	}
	
	private void reStructure() {
		int[] array = new int[arr.length + 10];
		for(int i=0; i<arr.length; i++) {
			array[i] = arr[i];
		}
		
		arr = array;
	}
	
	public void add(int e) {
		if(index == arr.length) reStructure();
		
		arr[index++] = e; 
	}
	
	public int size() {
		return index; //If index is 5 then it means we have added elements upto index 4 and hence size 5
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void set(int index, int element) throws IndexOutOfBoundException {   //Can be set from 0 to index
		if(index > this.index) {
			IndexOutOfBoundException e = new IndexOutOfBoundException();
			throw e;
		}
		
		if(index == this.index) add(element);
		
		arr[index] = element;
	}
	
	public int get(int index) throws IndexOutOfBoundException {
		if(index >= this.index) {
			IndexOutOfBoundException e = new IndexOutOfBoundException();
			throw e;
		}
		
		return arr[index];
	}
	
	public int removeLast() throws EmptyArrayException {
		if(size()==0) {
			EmptyArrayException e = new EmptyArrayException();
			throw e;
		}
		
		index--;
		int temp = arr[index];
		arr[index] = 0;
		return temp;
	}

}

