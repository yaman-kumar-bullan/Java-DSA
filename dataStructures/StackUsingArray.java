package dataStructures;

public class StackUsingArray  {

	public static void main(String[] args){
		
		StackUsingArrayImplementation stack = new StackUsingArrayImplementation(5);
		
		try {
			System.out.println(stack.peek());
		} catch (EmptyStackException e1) {
			System.out.println("Peeking from an empty stack");
		}
		
		for(int i=0; i<10; i++) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			try {
				System.out.print(stack.pop() + " ");
			} catch (EmptyStackException e) {
				System.out.println("Stack is empty now");
			}
		}

	}

}
