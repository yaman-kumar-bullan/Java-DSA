package questions;
import java.util.*;

public class Problems {
	
	public static int[] takeInputArray() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}
	
	public static void printArray(int[] input) {
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static int uniqueInArray(int[] arr) {
		int ans = 0;
		
		for(int i=0; i<arr.length; i++) {
			ans ^= arr[i];
		}
		
		return ans;
	}
	
	public static int singleDuplicateInArray(int[] arr) {
		/* 
		 * int[] count = new int[arr.length];

		for(int i=0; i<arr.length; i++) {
			if(count[arr[i]] == 1) return arr[i];
			count[arr[i]]++;
		}
		
		return -1;
		 */
		
		int ans = 0;
		
		for(int i=0; i<arr.length; i++) {
			ans ^= arr[i];
		}
		
		for(int i=0; i<=arr.length-2; i++) {
			ans ^= i;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(3);
		pq.add(1);
		pq.add(7);
		pq.add(5);
		pq.add(9);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

}
