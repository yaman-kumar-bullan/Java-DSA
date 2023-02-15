package binaryTree;

import java.util.Scanner;

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
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeBTInputAlternate(sc);
		
		
	}
}
