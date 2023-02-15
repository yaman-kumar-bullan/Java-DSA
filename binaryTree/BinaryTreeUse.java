package binaryTree;
import java.util.Scanner;

import dataStructures.EmptyQueueException;
import dataStructures.QueueUsingLLGenericImplementation;

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

	public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			Pair<Integer,Integer> output = new Pair<>(0,0);
			return output;
		}

		Pair<Integer,Integer> lo = heightDiameter(root.left);
		Pair<Integer,Integer> ro = heightDiameter(root.right);

		int height = Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));

		Pair<Integer,Integer> output = new Pair<>(height,diameter);
		return output;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputBTLevelWise();
		System.out.println(diamterOfBT(root));
	}
}
