package ExceptionHandling;

public class DynamicArrayUse {
	
	public static void main(String[] args) {
		
		DynamicArray d = new DynamicArray();
		
		for(int i=0; i<100; i++) {
			d.add(i+10);
		}
		
		System.out.println(d.size());
		
		try {
			d.set(4, 10);
		} catch(IndexOutOfBoundException e) {
			System.out.println("Index is out of range");
		}
		
		try {
			System.out.println(d.get(4));
		} catch(IndexOutOfBoundException e) {
			System.out.println("Index is out of bound");
		}
		
		while(!d.isEmpty()) {
			
			try {
				System.out.println(d.removeLast());
			} catch(EmptyArrayException e) {
				System.out.println("Array is empty");
			}
			
			System.out.println("size = " + d.size());
		}
	}

}

