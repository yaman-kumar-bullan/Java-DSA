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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputBTLevelWise();
		printNodesWithoutSibling(root);
	}
}
