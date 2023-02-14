package dataStructures;
import java.util.*;
public class LinkedListUse {
	
	public static void main(String[] args) {
		Node<Integer> head = takeInputOfLL();
		printLL(evenAfterOddLL(head));
	}
	
	public static Node<Integer> takeInputOfLL() {
		Scanner sc = new Scanner(System.in);
		
		Node<Integer> head = null, tail = null;
		
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				/*
				 * Node<Integer> temp = head;   //This was resulting in o(n2)
				while(temp.next != null) temp = temp.next;
				temp.next = newNode;
				 */
				tail.next = newNode;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		
		return head;
	}
	
	public static<T> void printLL(Node<T> head) {
		Node<T> temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}

	//This function will return me the head node of the resultant list
	
	public static Node<Integer> insertNodeInLL2(Node<Integer> head, int pos, int data) {
		Node<Integer> newNode = new Node<>(data);
		
		/*We will have to handle the case when the pos is 0 .. In that case 
		 * pos = 0, index = 0 .. so in while loop (0 != -1)
		 * When pos = 1, index = 0 .. so in while loop (0 != 0) .. so newNode will go
		 * in the next position of head that's what we want
		 */
		
		if(pos == 0) {
			newNode.next = head;
			return newNode;
		}
		
		int index = 0;
		Node<Integer> temp = head;
		
		while(index != pos-1) {
			temp = temp.next;
			index++;
		}
		
		//Now temp node is at pos-1
		
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static Node<Integer> insertNodeInLL(Node<Integer> head, int pos, int data) {
		Node<Integer> newNode = new Node<>(data);
		
		if(pos==0) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		
		Node<Integer> temp = head;
		int index = 0;
		
		while(index != pos-1) {  //After first iteration temp is at Node 1 and index is 1 --> So when index is i-1 temp is at i-1 node
			temp = temp.next;
			index++;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
		
		return head;
	}
	
	public static Node<Integer> deleteNodeInLL(Node<Integer> head, int pos) {
		
		if(pos==0) return head.next;
		
		Node<Integer> temp = head;
		int index = 0;
		
		while(index != pos-1) {
			temp = temp.next;
			index++;
		}
		
		temp.next = temp.next.next;
		return head;
	}
	
	public static int lengthOfLL(Node<Integer> head) {
		int index = 0;
		Node<Integer> temp = head;
		
		/*
		 * When temp is at last node .. index has the index of last node
		 * So overall size will be index of last node + 1 .. i.e, n 
		 * index will be equal to size when node is null
		 */
		
		while(temp != null) { 
			temp = temp.next;
			index++;
		}
		
		return index;
	}
	
	public static int printIthNode(Node<Integer> head, int i) {
		if(i==0) return head.data;
		
		int pos = 0;
		Node<Integer> temp = head;
		
		while(pos != i) {
			temp = temp.next;
			pos++;
		}
		
		return temp.data;
	}
	
	public static int midPointOfLL(Node<Integer> head) {
		int index = 0;
		Node<Integer> temp = head;
		while(temp != null) {
			temp = temp.next;
			index++;
		}

		int n = index; //size

		int pos = n%2==0 ? (n/2)-1 : (n-1)/2;

		index = 0;
		temp = head;

		while(index != pos) {
			temp = temp.next;
			index++;
		}

		return temp.data;
	}
	
	public static Node<Integer> mergeTwoSortedLinkedLists2(Node<Integer> head1, Node<Integer> head2) {  //Different Implementaion
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		//If both are null then upper statements will always be valid

		Node<Integer> head = null, tail = null;

		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				if(head == null) {
					head = head1;
					tail = head1;
					head1 = head1.next;
				} else {
					tail.next = head1;
					tail = tail.next;
					head1 = head1.next;
				}
			} else {
				if(head == null) {
					head = head2;
					tail = head2;
					head2 = head2.next;
				} else {
					tail.next = head2;
					tail = tail.next;
					head2 = head2.next;
				}
			}
		}

		if(head1 != null) tail.next = head1;
		if(head2 != null) tail.next = head2;

		return head;
	}

	public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> ansHead = null;
		
		if(head1.data <= head2.data) {
			ansHead = head1;
			head1 = head1.next;
		} else {
			ansHead = head2;
			head2 = head2.next;
		}
		
		Node<Integer> temp = ansHead;
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		
		if(head1 != null) temp.next = head1;
		
		if(head2 != null) temp.next = head2;
		
		return ansHead;
	}
	
	public static int indexOfMidNodeInLL(Node<Integer> head) {
		int n = lengthOfLL(head);
		return n%2==0 ? (n/2)-1 : (n-1)/2;
	}

	public static Node<Integer> mergeSort2(Node<Integer> head) {
		if(head == null || head.next == null) return head;

		int mid = indexOfMidNodeInLL(head);  //Index of mid Node

		int index = 0;
		Node<Integer> temp = head;

		while(index != mid) {
			temp = temp.next;
			index++;
		}

		Node<Integer> head2 = temp.next;
		Node<Integer> head1 = head;
		temp.next = null;

		head1 = mergeSort2(head1);
		head2 = mergeSort2(head2);
		Node<Integer> ansHead = mergeTwoSortedLinkedLists(head1, head2);
		return ansHead;
	}

	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		int n = lengthOfLL(head);
		
		int pos;
		
		if(n % 2 == 0) pos = (n/2)-1;
		else pos = n/2;
		
		int index = 0;
		Node<Integer> temp = head;
		
		while(index != pos) {
			temp = temp.next;
			index++;
		}
		
		Node<Integer> head1 = head;
		Node<Integer> head2 = temp.next;
		temp.next = null;
		
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		
		Node<Integer> ansHead = mergeTwoSortedLinkedLists(head1, head2);
		return ansHead;
	}
	
	public static Node<Integer> reverseLLRecursively(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> smallAns = reverseLLRecursively(head.next);
		
		head.next.next = head;  //Current head ka next is tail of new ll
		head.next = null;       //now head is tail of ll so tail next should be null
		
		return smallAns;
	}
	
	public static Node<Integer> reverseLLIteratively(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> prev = null;
		Node<Integer> temp = head;
		
		while(temp != null) {
			Node<Integer> nextNode = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nextNode;
		}
		
		return prev;
	}
	
	public static Node<Integer> deleteRecursively2(Node<Integer> head, int pos) {
		if(pos == 0) return head.next;

		Node<Integer> smallHead = deleteRecursively2(head.next, pos-1);
		head.next = smallHead;
		return head;
	}

	public static Node<Integer> insertRecursively2(Node<Integer> head, int pos, int data) {
		if(pos == 0) {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = head;
			return newNode;
		}

		Node<Integer> smallHead = insertRecursively2(head.next, pos-1, data);
		head.next = smallHead;
		return head;
	}

	public static Node<Integer> insertRecursively(Node<Integer> head, int pos, int data) {
		if(pos == 0) {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = head;
			return newNode;
		}
		
		Node<Integer> smallHead = insertRecursively(head.next, pos-1, data);
		head.next = smallHead;
		return head;
	}
	
	public static int findNodeInLL2(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		int index = 0;

		while(temp != null) {
			if(temp.data == n) return index;
			temp = temp.next;
			index++;
		}

		return -1;
	}

	public static boolean findNodeInLL3(Node<Integer> head, int n) {
		if(head == null) return false;
		if(head.data == n) return true;

		if(findNodeInLL3(head.next, n)) return true;
		
		return false;
	}

	public static int findIndexOfNodeInLLRecursively(Node<Integer> head, int pos, int n) {
		if(head == null) return -1;
		if(head.data == n) return pos;

		return findIndexOfNodeInLLRecursively(head.next, pos+1, n);
	}

	public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {
		if(pos == 0) return head.next; //Head should not be null
		
		Node<Integer> smallHead = deleteRecursively(head.next, pos-1);
		head.next = smallHead;
		return head;
	}
	
	public static Node<Integer> appendLastNNodeToFirst(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		while(temp.next != null) temp = temp.next;

		Node<Integer> currentTail = temp;

		int size = lengthOfLL(head);
		int index = size - n - 1; //Index of last node from the starting before the first node of the new LL

		if(index == -1) return head; //This will in only one case when n is equal to size of ll

		temp = head;
		int pos = 0;

		while(pos < index) { //Here i can keep it as != also because the case when n is equal to size is handled above
			temp = temp.next;
			pos++;
		}

		Node<Integer> newHead = temp.next;
		currentTail.next = head;
		temp.next = null;  //temp is going to be the new Tail
		return newHead;
	}

	public static int findNodeInLL(Node<Integer> head, int n) {
		
		Node<Integer> temp = head;
		int pos = 0;
		
		while(temp != null) {
			if(temp.data == n) return pos;
			pos++;
			temp = temp.next;
		}
		
		return -1;
	}
	
	public static void printLLReverseRecursive2(Node<Integer> head) {
		if(head.next == null) {
			System.out.print(head.data + " ");
			return;
		}

		printLLReverseRecursive2(head.next);
		System.out.print(head.data + " ");
	}

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		int size = lengthOfLL(head);
		
		int pos = size - n -1; //Index of last node before the n nodes begin
		
		Node<Integer> temp = head;
		int index = 0;
		
		while(index != pos) {
			temp = temp.next;
			index++;
		}
		
		Node<Integer> newTail = temp;
		Node<Integer> newHead = temp.next;
		
		while(temp.next != null) temp = temp.next;
		
		Node<Integer> currTail = temp;
		
		currTail.next = head;
		newTail.next = null;
		return newHead;
	}
	
	public static boolean checkPalindrome(String str, int si, int ei) {
		if(si >= ei) return true;

		if(str.charAt(si) != str.charAt(ei)) return false;
		return checkPalindrome(str, si+1, ei-1);
	}

	public static boolean checkPalindromeLL(Node<Integer> head) {
		StringBuilder sb = new StringBuilder();
		Node<Integer> temp = head;
		while(temp != null) {
			sb.append(temp.data);
			temp = temp.next;
		}
		String str = sb.toString();
		return checkPalindrome(str, 0, str.length()-1);
	}

	public static void printReverseLLRecursive(Node<Integer> head) {
		
		if(head == null || head.next == null) {
			System.out.print(head.data + " ");
			return;
		}
		
		printReverseLLRecursive(head.next);
		System.out.print(head.data + " ");
	}
	
	public static Node<Integer> removeConsecutiveDuplicates2(Node<Integer> head) {
		Node<Integer> head1 = head;
		Node<Integer> head2 = head;

		while(head1 != null) {
			while(head2 != null && head2.data == head1.data) {
				head2 = head2.next;
			}
			head1.next = head2;
			head1 = head1.next;
		}

		return head;
	}

	public static boolean checkPalindromeInLL(Node<Integer> head, int si, int ei) {
		if(si >= ei) return true;
		
		Node<Integer> temp = head;
		int index = si; //Because head will not always be at index 0 during recursion calling
		
		while(index != ei) {
			temp = temp.next;
			index++;
		}
		
		if(head.data != temp.data) return false;
		
		return checkPalindromeInLL(head.next, si+1, ei-1);
	}
	
	public static Node<Integer> removeConsecutiveDuplicates(Node<Integer> head) {  //List is already sorted in ascending order
		if(head == null || head.next == null) return head;
		
		Node<Integer> prev = head;
		Node<Integer> temp = head.next;
		
		while(temp != null) {
			if(prev.data == temp.data) temp = temp.next;
			else {
				prev.next = temp;
				temp = temp.next;
				prev = prev.next;
			}
		}
		
		prev.next = null;   //Prev will have tail of newly constructed LL
		return head;
	}
	
	public static Node<Integer> evenAfterOddLL(Node<Integer> head) {
		Node<Integer> temp = head, evenHead = null, evenTail = null, oddHead = null, oddTail = null;

		while(temp != null) {
			if(temp.data % 2 == 0) {
				if(evenHead == null) {
					evenHead = temp;
					evenTail = temp;
					temp = temp.next;
				} else {
					evenTail.next = temp;
					evenTail = evenTail.next;
					temp = temp.next;
				}
			} else {
				if(oddHead == null) {
					oddHead = temp;
					oddTail = temp;
					temp = temp.next;
				} else {
					oddTail.next = temp;
					oddTail = oddTail.next;
					temp = temp.next;
				}
			}
		}

		if(evenHead == null) return oddHead;
		if(oddHead == null) return evenHead;

		if(evenTail.next != null) evenTail.next = null;
		if(oddTail.next != null) oddTail.next = null;

		oddTail.next = evenHead;
		return oddHead;
	}

	public static int findANodeInLL(Node<Integer> head, int n, int pos) {
		if(head == null) return -1;
		
		if(head.data == n) return pos;
		return findANodeInLL(head.next, n, pos+1);
	}
	
	public static Node<Integer> swapTwoNodes(Node<Integer> head, int i, int j) {  //Don't know
		Node<Integer> prev = null, curr = head;
		int index = 0;
		
		while(curr != null && index != i) {
			prev = curr;
			curr = curr.next;
		}
		
		Node<Integer> prevI = prev;
		Node<Integer> currI = curr;
		
		prev = null;
		curr = head;
		index = 0;
		
		while(curr != null && index != j) {
			prev = curr;
			curr = curr.next;
		}
		
		Node<Integer> prevJ = prev;
		Node<Integer> currJ = curr;
		
		if(i==j) return head;
		
		if(i == 0 || j == 0) {
			
		}
		
		return head; //To remove erro
		
		
	}
	
	public static int fact(int n) {
		if(n==0) return 1;
		
		return n * fact(n-1);
	}
	
}
