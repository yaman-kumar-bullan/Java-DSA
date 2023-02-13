package dataStructures;
import java.util.*;

public class StackAndQueueQuestions {
	
	public static boolean checkParanthesis(String str) {
		if(str.length() == 0) return true;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
				if(str.charAt(i) == ')' && stack.peek() != '(') return false;
				else if(str.charAt(i) == '}' && stack.peek() != '{') return false;
				else if(str.charAt(i) == ']' && stack.peek() != '[') return false;
				else stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.size()>0) {
			int temp = stack.pop();
			reverseStack(stack);
			insert_at_bottom(stack, temp);
		}
	}
	
	public static void insert_at_bottom(Stack<Integer> stack, int x) {
		if(stack.isEmpty()) {
			stack.push(x);
		} else {
			int temp = stack.pop();
			insert_at_bottom(stack, x);
			stack.push(temp);
		}
	}
	
	public static void reverseQueue(Queue<Integer> queue) {
		if(queue.size() > 0) {
			int temp = queue.poll();
			reverseQueue(queue);
			queue.add(temp);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=4; i++) {
			queue.add(i*10);
		}
		
		reverseQueue(queue);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
