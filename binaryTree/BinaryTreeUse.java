package binaryTree;

import java.util.Scanner;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter the next node data : ");
		int rootData = sc.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		System.out.println("Enter number of childrens of " + root.data + " : ");
		int numChild = sc.nextInt();
		
		for(int i=0; i<numChild; i++) {
			BinaryTreeNode<Integer> child = takeInput(sc);
			if(i==0) root.left = child;
			else root.right = child;
		}
		
		return root;
	}
	
	public static void printBinaryTree(BinaryTreeNode<Integer> root) {
		
	}
	
	public static void main(String[] args) {
	
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		root.left = node1;
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
		root.right = node2;
		
	}
}
