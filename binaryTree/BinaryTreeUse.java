package binaryTree;
import java.util.*;

import dataStructures.*;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeBTInputAlternate(Scanner sc) {
		System.out.println("Enter the next node data : ");
		int rootData = sc.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		System.out.println("Enter number of childrens of " + root.data + " : ");
		int numChild = sc.nextInt();
		
		for(int i=0; i<numChild; i++) {
			BinaryTreeNode<Integer> child = takeBTInputAlternate(sc);
			if(i==0) root.left = child;
			else root.right = child;
		}
		
		return root;
	}
	
	public static void printBTAlternate(BinaryTreeNode<Integer> root) {

		if(root == null) return;

		String str = root.data + ":";
		if(root.left != null) str += root.left.data + ",";
		if(root.right != null) str += root.right.data + ",";

		System.out.println(str);

		if(root.left != null) printBTAlternate(root.left);
		if(root.right != null) printBTAlternate(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInputBT(Scanner sc ) {
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		if(rootData == -1) return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		root.left = takeInputBT(sc);
		root.right = takeInputBT(sc);

		return root;
	}

	public static void printBT(BinaryTreeNode<Integer> root) {
		if(root == null) return;

		String str = root.data + ":";
		if(root.left != null) str = str + "L" + root.left.data + ",";
		if(root.right != null) str = str + "R" + root.right.data;
		System.out.println(str);

		printBT(root.left);  //Here i can also write if(root.left != null) printBT(root.left);
		printBT(root.right);
	}

	public static BinaryTreeNode<Integer> takeInputBTLevelWise() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		if(rootData == -1) return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (EmptyQueueException e) {
				return null;
			}

			System.out.println("Enter left child of " + front.data + ":");
			int leftChildData = sc.nextInt();
			if(leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
				pendingNodes.enqueue(leftChild);
				front.left = leftChild;
			}

			System.out.println("Enter right child of " + front.data + ":");
			int rightChildData = sc.nextInt();
			if(rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
				pendingNodes.enqueue(rightChild);
				front.right = rightChild;
			}
		}

		return root;
	}

	public static void printBTLevelWise(BinaryTreeNode<Integer> root) {
		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (EmptyQueueException e) {
				return;
			}

			if(front == null) return;

			String str = front.data + ":";
			if(front.left != null) {
				str = str + "L" + front.left.data + ",";
				pendingNodes.enqueue(front.left); 
			}

			if(front.right != null) {
				str = str + "R" + front.right.data;
				pendingNodes.enqueue(front.right); 
			}

			System.out.println(str);
		}
	}

	public static int numberOfNodesInBT(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;

		int count = 0;

		count += numberOfNodesInBT(root.left) + numberOfNodesInBT(root.right); //Here we don't have to check that root.left is null or not because if they will be null then also no problem cause base condition will work in that case
		return count+1; //To take into consideration the current node
	}

	public static int heightOfBT(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;

		int leftHeight = heightOfBT(root.left);
		int rightHeight = heightOfBT(root.right);
		int temp = Math.max(leftHeight,rightHeight); 
		return temp+1; //Considering the root node also
	}

	public static int diamterOfBT(BinaryTreeNode<Integer> root) { 
		/* The time complexity of this algorithm is (n*h),
		 * where h is the height of tree & n is number of nodes
		 */
		if(root==null) return 0;

		int option1 = heightOfBT(root.left) + heightOfBT(root.right);
		int option2 = diamterOfBT(root.left);
		int option3 = diamterOfBT(root.right);

		int finalDiameter = Math.max(option1, Math.max(option2, option3));
		return finalDiameter;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		return heightDiameter(root).first;
	}

	public static int diameter(BinaryTreeNode<Integer> root) {
		return heightDiameter(root).second;
	}

	public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			Pair<Integer,Integer> output = new Pair<>(0,0);
			return output;
		}

		Pair<Integer,Integer> lo = heightDiameter(root.left);
		Pair<Integer,Integer> ro = heightDiameter(root.right);

		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));

		Pair<Integer,Integer> output = new Pair<>(height,diameter);
		return output;
	}

	public static void preOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root==null) return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public static void postOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root == null) return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	public static void inOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root==null) return;

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	//Very Very Important Question
	public static BinaryTreeNode<Integer> constructTreeWithPreAndInOrderTraversal(int[] preOrder, int[] inOrder, int pS, int pE, int iS, int iE) {
		if(pS>pE || iS>iE) return null; //Base case

		int rootData = preOrder[pS];

		int leftTreeInOrderStarting = iS;
		int index;

		for(index=iS; index<=iE; index++) {
			if(inOrder[index] == rootData) break;
		}

		int leftTreeInOrderEnding = index-1;
		
		int leftTreePreOrderStarting = pS+1;
		int inOrderTreeLength = leftTreeInOrderEnding - leftTreeInOrderStarting + 1;
		/* We know that
		 * leftPreE - leftPreS = rightPreE - rightPreS
		 * So, leftPreE = rightPreE - rightPreS + leftPreS
		 */
		int leftTreePreOrderEnding = leftTreePreOrderStarting + inOrderTreeLength - 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		root.left = constructTreeWithPreAndInOrderTraversal(preOrder, inOrder, leftTreePreOrderStarting, leftTreePreOrderEnding, leftTreeInOrderStarting, leftTreeInOrderEnding);

		int rightTreeInOrderStarting = leftTreeInOrderEnding + 2;
		int rightTreeInOrderEnding = iE;
		int rightTreePreOrderStarting = leftTreePreOrderEnding+1;
		int rightTreePreOrderEnding = pE;

		root.right = constructTreeWithPreAndInOrderTraversal(preOrder, inOrder, rightTreePreOrderStarting, rightTreePreOrderEnding, rightTreeInOrderStarting, rightTreeInOrderEnding);

		return root;
	}

	public static BinaryTreeNode<Integer> constructTreeWithPostAndInOrderTraversal(int[] postOrder, int[] inOrder, int pS, int pE, int iS, int iE) {
		if(pS>pE || iS>iE) return null;

		int rootData = postOrder[pE];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

		int leftTreeInOrderStarting = iS;
		int index;

		for(index = iS; index<=iE; index++) {
			if(inOrder[index] == rootData) break;
		}

		int leftTreeInOrderEnding = index-1;

		int inOrderLength = leftTreeInOrderEnding - leftTreeInOrderStarting + 1;
		
		int leftTreePostOrderStarting = pS;
		int leftTreePostOrderEnding = leftTreePostOrderStarting + inOrderLength - 1;

		root.left = constructTreeWithPostAndInOrderTraversal(postOrder, inOrder, leftTreePostOrderStarting, leftTreePostOrderEnding, leftTreeInOrderStarting, leftTreeInOrderEnding);

		int rightTreeInOrderStarting = leftTreeInOrderEnding + 2;
		int rightTreeInOrderEnding = iE;

		int rightTreePostOrderStarting = leftTreePostOrderEnding+1;
		int rightTreePostOrderEnding = pE-1;

		root.right = constructTreeWithPostAndInOrderTraversal(postOrder, inOrder, rightTreePostOrderStarting, rightTreePostOrderEnding, rightTreeInOrderStarting, rightTreeInOrderEnding);
		return root;
	}


	public static boolean findNodeInBT(BinaryTreeNode<Integer> root, int x) {
		if(root==null) return false;

		if(root.data == x) return true;

		boolean isPresent = (findNodeInBT(root.left, x) || findNodeInBT(root.right, x)) ? true : false;
		return isPresent;
	}

	public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> root) {
		if(root == null) return null;

		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;

		mirror(root.left);
		mirror(root.right);

		return root;
	}

	public static int sumOfAllNodes(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;

		int sum = root.data;
		sum = sum + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
		return sum;
	}

	public static int depth2(BinaryTreeNode<Integer> root) {  //This is not correct
		/*Here we are assuming that height and depth is not same
		 *But actually in case of trees both are same
		 */
		if(root.left == null && root.right == null) return 0;

		int smallDepth;
		if(root.left == null) smallDepth = depth(root.right);
		else if(root.right == null) smallDepth = depth(root.left);
		else smallDepth = Math.max(depth(root.left), depth(root.right));

		return 1 + Math.max(depth(root.left),depth(root.right));
	}

	public static int depth(BinaryTreeNode<Integer> root) {
		return heightOfBT(root);
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) return true;

		int depthLeft = depth(root.left);
		int depthRight = depth(root.right);
		int diff = depthLeft >= depthRight ? depthLeft - depthRight : depthRight - depthLeft;
		if(diff > 1) return false;
		if(isBalanced(root.left) || isBalanced(root.right)) return true;
		return false;
	}

	public static void printLevelOrderTraversal2(BinaryTreeNode<Integer> root) { //Without a new line after every level
		if(root==null) return;

		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingQueues = new QueueUsingLLGenericImplementation<>();
		pendingQueues.enqueue(root);

		while(!pendingQueues.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingQueues.dequeue();
			} catch(EmptyQueueException e) {
				return;
			}

			System.out.print(front.data);
			
			if(front.left != null) pendingQueues.enqueue(front.left);
			if(front.right != null) pendingQueues.enqueue(front.right);
			System.out.println();
		}
	}

	public static void printLevelOrderTraversal(BinaryTreeNode<Integer> root) {  //5* Question
		if(root==null) return;

		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingQueues = new QueueUsingLLGenericImplementation<>();
		pendingQueues.enqueue(root);

		while(!pendingQueues.isEmpty()) {
			int nodeCount = pendingQueues.size(); //This is the number of nodes at the current level
			while(nodeCount-- > 0) { //When this while loop gets completed then all the nodes at this current level would have got printed in a same line
				BinaryTreeNode<Integer> front;
				try {
					front = pendingQueues.dequeue();
				} catch (EmptyQueueException e) {
					return;
				}

				System.out.print(front.data + " ");
				if(front.left != null) pendingQueues.enqueue(front.left);
				if(front.right != null) pendingQueues.enqueue(front.right);

			}
			System.out.println(); //To print the next level nodes in the next line
		}
	}

	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
		if(root == null) return null;

		if(root.left == null && root.right == null) return null;  //Base condition

		if(root.left != null) root.left = removeLeafNodes(root.left);
		if(root.right != null) root.right = removeLeafNodes(root.right);

		return root;
	}

	public static ArrayList<Node<Integer>> levelWiseLinkedList(BinaryTreeNode<Integer> root) { //5*
		
		ArrayList<Node<Integer>> al = new ArrayList<>();
		
		if(root == null) return al;

		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingQueues = new QueueUsingLLGenericImplementation<>();
		pendingQueues.enqueue(root);

		while(!pendingQueues.isEmpty()) {
			Node<Integer> head = null, tail = null;
			int nodeCount = pendingQueues.size();

			while(nodeCount-- > 0) {
				BinaryTreeNode<Integer> front;
				try {
					front = pendingQueues.dequeue();
				} catch (EmptyQueueException e) {
					return al;
				}
				Node<Integer> newNode = new Node<>(front.data);
				if(head == null) {
					head = newNode;
					tail = newNode;
				} else {
					tail.next = newNode;
					tail = tail.next;
				}

				if(front.left != null) pendingQueues.enqueue(front.left);
				if(front.right != null) pendingQueues.enqueue(front.right);
			}

			al.add(head);
		}

		return al;
	}

	public static void printZigZagBinaryTree(BinaryTreeNode<Integer> root) { //4* Question
		if(root == null) return;

		QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingQueues = new QueueUsingLLGenericImplementation<>();
		pendingQueues.enqueue(root);
		int index = 1;

		while(!pendingQueues.isEmpty()) {
			int nodeCount = pendingQueues.size();
			if(index % 2 != 0) {
				while(nodeCount-- > 0) {
					BinaryTreeNode<Integer> front;
					try {
						front = pendingQueues.dequeue();
					} catch (EmptyQueueException e) {
						return;
					}

					System.out.print(front.data + " ");
					if(front.left != null) pendingQueues.enqueue(front.left);
					if(front.right != null) pendingQueues.enqueue(front.right);
				}
			} else {
				ArrayList<BinaryTreeNode<Integer>> al =  new ArrayList<>();
				while(nodeCount-- > 0) {
					BinaryTreeNode<Integer> front;
					try {
						front = pendingQueues.dequeue();
					} catch (EmptyQueueException e) {
						return;
					}
					al.add(front);
					if(front.left !=  null) pendingQueues.enqueue(front.left);
					if(front.right != null) pendingQueues.enqueue(front.right);
				}
				for(int i=al.size()-1; i>=0; i--) {
					System.out.print(al.get(i).data + " ");
				}
			}
			index++;
			System.out.println();
		}
	}

	public static void printLinkedList(Node<Integer> head) {
		if(head == null) return;

		Node<Integer> temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root == null) return;

		if(root.left == null && root.right  == null) {
			System.out.println(root.data + " ");
			return;
		}

		if(root.left != null) printNodesWithoutSibling(root.left);
		if(root.right != null) printNodesWithoutSibling(root.right);

	}

	/* From here code of Binary Search Tree has started */

	public static boolean binarySearch(int[] arr, int x, int si, int ei) {
		if(si>ei) return false;

		int mid = (si+ei)/2;

		if(arr[mid] == x) return true;
		else if(arr[mid] > x) return binarySearch(arr, x, si, mid-1);
		else return binarySearch(arr, x, mid+1, ei);
	}

	public static BinaryTreeNode<Integer> constructABST(int[] arr, int si, int ei) {
		if(si>ei) return null;  //Base condition

		int mid = (si+ei)/2;
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(arr[mid]);
		newNode.left = constructABST(arr, si, mid-1);
		newNode.right = constructABST(arr, mid+1, ei);

		return newNode;
	}

	public static BinaryTreeNode<Integer> searchNodeInBST(BinaryTreeNode<Integer> root, int x) {
		if(root == null) return null;

		if(root.data == x) return root;

		if(root.data > x) return searchNodeInBST(root.left, x);
		else return searchNodeInBST(root.right, x);

	}

	public static void printBetweenRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(k1 > k2) {
			int temp = k1;
			k1 = k2;
			k2 = k1;
		}

		if(root == null) return;

		if(root.data >= k1 && root.data <= k2) System.out.print(root.data + " ");

		if(root.data <= k1) printBetweenRange(root.right, k1, k2);
		else if(root.data >= k2) printBetweenRange(root.left, k1, k2);
		else {
			printBetweenRange(root.left, k1, k2);
			printBetweenRange(root.right, k1, k2);
		}
	}

	public static int max(BinaryTreeNode<Integer> root) {
		if(root == null) return Integer.MIN_VALUE;

		if(root.right == null) return root.data;
		else return max(root.right);
	}

	public static int min(BinaryTreeNode<Integer> root) {
		if(root == null) return Integer.MAX_VALUE;

		if(root.left == null) return root.data;
		else return min(root.left);
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) { //5*
		if(root == null) return true;

		int leftMax = max(root.left);
		int rightMin = min(root.right);

		if(root.data < leftMax || root.data > rightMin) return false;

		if(isBST(root.left) && isBST(root.right)) return true;

		return false;
	}

	public static Pair<Pair<Integer, Integer>, Boolean> isBST2(BinaryTreeNode<Integer> root) {
		if(root == null) { 
			Pair<Integer, Integer> minMax = new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Pair<Pair<Integer, Integer>, Boolean> ans = new Pair<>(minMax, true);
			return ans;
		}

		Pair<Pair<Integer, Integer>, Boolean> leftOutput = isBST2(root.left);
		Pair<Pair<Integer, Integer>, Boolean> rightOutput = isBST2(root.right);

		int min = Math.min(root.data, Math.min(leftOutput.first.first, rightOutput.first.first));
		int max = Math.max(root.data, Math.max(leftOutput.first.second, rightOutput.first.second));

		int leftMax = leftOutput.first.second;
		int rightMin = rightOutput.first.first;

		if(root.data <= leftMax || root.data >= rightMin) {
			return new Pair<>(new Pair<>(min, max), false);
		}

		if(leftOutput.second && rightOutput.second) {
			return new Pair<>(new Pair<>(min, max), true);
		}

		return new Pair<>(new Pair<>(min, max), false);
	}

	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if(root == null) return true;

		if(root.data < min || root.data > max) return false;

		boolean isLeftOk = isBST3(root.left, min, root.data-1);
		boolean isRightOk = isBST3(root.right, root.data+1, max);

		return isLeftOk && isRightOk;
	}

	public static Node<Integer> BSTtoLL(BinaryTreeNode<Integer> root) {
		if(root == null) return null;

		Node<Integer> newNode = new Node<>(root.data);
		Node<Integer> head = newNode, current = newNode;

		if(root.left != null) {
			Node<Integer> leftHead = BSTtoLL(root.left);
			Node<Integer> temp = leftHead;
			while(temp.next != null) temp = temp.next;
			temp.next = head;
			head = leftHead;
		}

		if(root.right != null) {
			Node<Integer> rightHead = BSTtoLL(root.right);
			current.next = rightHead;
		}

		return head;
	}

	public static ArrayList<Integer> rootToNodePathForBST(BinaryTreeNode<Integer> root, ArrayList<Integer> al, int k) {
		if(root == null) {
			return new ArrayList<>();
		}

		al.add(root.data);
		if(root.data == k) return al;

		if(root.data > k) return rootToNodePathForBST(root.left, al, k);
		if(root.data < k) return rootToNodePathForBST(root.right, al, k);

		return new ArrayList<>();
	}

	public static boolean isPresent(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return false;
		}

		if(root.data == k) return true;
		if(isPresent(root.left, k) || isPresent(root.right, k)) return true;
		
		return false;
	}

	public static ArrayList<Integer> rootToNodePath(BinaryTreeNode<Integer> root, ArrayList<Integer> al, int k) {
		if(root == null) {
			return new ArrayList<>();
		}

		al.add(root.data);
		if(root.data == k) return al;

		if(isPresent(root.left, k)) {
			return rootToNodePath(root.left, al, k);
		}

		if(isPresent(root.right, k)) {
			return rootToNodePath(root.right, al, k);
		}

		return new ArrayList<>();
	}

	public static ArrayList<Integer> rootToNodePath2(BinaryTreeNode<Integer> root, int k) {  // Not using a arraylist to store all the data
		if(root == null) return null;

		if(root.data == k) {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(root.data);
			return al;
		}

		ArrayList<Integer> leftOutput = rootToNodePath2(root.left, k);
		if(leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}

		ArrayList<Integer> rightOutput = rootToNodePath2(root.right, k);
		if(rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}

		return null;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputBTLevelWise();
		int k = sc.nextInt();
		ArrayList<Integer> al = rootToNodePath2(root,k);
		for(int i=al.size()-1; i>=0; i--) {
			System.out.println(al.get(i));
		}
	}
}
