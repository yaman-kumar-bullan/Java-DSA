package trees;
import java.util.*;

import dataStructures.EmptyQueueException;
import dataStructures.QueueUsingLLGenericImplementation;
public class TreeUse {
	
	public static TreeNode<Integer> takeInput(Scanner sc) {
		
		System.out.println("Enter next node data");
		int n = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = sc.nextInt();
		for(int i=0; i<childCount; i++) {
			TreeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String str = root.data + ":";
		
		for(int i=0; i<root.children.size(); i++) {
			str = str + root.children.get(i).data + ",";
		}
		
		System.out.println(str);
		
		for(int i=0; i<root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		
		QueueUsingLLGenericImplementation<TreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = sc.nextInt();
				for(int i=1; i<=numChildren; i++) {
					System.out.println("Enter " + i + "th child of " + frontNode.data);
					int child = sc.nextInt();
					TreeNode<Integer> childNode = new TreeNode<>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (EmptyQueueException e) {
				// Not gonna reach this statement
				return null;
			}
		}
		
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		QueueUsingLLGenericImplementation<TreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				String s = frontNode.data + ":";
				for(int i=0; i<frontNode.children.size(); i++) {
					TreeNode<Integer> child = frontNode.children.get(i);
					s = s + child.data + ",";
					pendingNodes.enqueue(child);
				}
				System.out.println(s);
			} catch (EmptyQueueException e) {
				//Not gonna run ever
				return;
			}
		}
	}

	public static int numberOfTreeNodes(TreeNode<Integer> root) {
		
		if(root == null) return 0;   //This is not a base 
		
		int numNodes = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallAns = numberOfTreeNodes(root.children.get(i));
			numNodes += smallAns;
		}
		
		return 1+numNodes;  //Here 1 is for root node
	}
	
	public static int nodeWithLargestData(TreeNode<Integer> root) {
		
		if(root == null) return Integer.MIN_VALUE;
		
		int max = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallAns = nodeWithLargestData(root.children.get(i));
			if(smallAns > max) max = smallAns;
		}
		
		return max;
	}
	
	public static int heightOfTree(TreeNode<Integer> root) {
		
		if(root == null) return Integer.MIN_VALUE;
		
		int height = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallAns = heightOfTree(root.children.get(i));
			if(smallAns > height) height = smallAns;
		}
		
		return 1+height;
	}
	
	public static void printNodesAtKDepth(TreeNode<Integer> root, int k) {
		if(k==0) {
			System.out.print(root.data + ",");
			return;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			printNodesAtKDepth(root.children.get(i), k-1);
		}
	}
	
	public static int numberOfLeafNodes(TreeNode<Integer> root) {
		
		if(root == null) return 0;
		
		int numLeafNodes = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallAns = numberOfLeafNodes(root.children.get(i));
			numLeafNodes += smallAns;
		}
		
		if(numLeafNodes != 0) return numLeafNodes;
		else return 1; //Base case is handling that root has no children so root is a leaf itself
	}
	
	public static void preOrderTraversal(TreeNode<Integer> root) {
		
		if(root == null) return;
		
		System.out.print(root.data + " ");
		for(int i=0; i<root.children.size(); i++) {
			preOrderTraversal(root.children.get(i));
		}
		
	}
	
	public static void postOrderTraversal(TreeNode<Integer> root) {
		
		if(root == null) return;
		
		for(int i=0; i<root.children.size(); i++) {
			postOrderTraversal(root.children.get(i));
		}
		
		System.out.print(root.data + " ");
	}
	
	public static int numberOfNodesGreaterThanX(TreeNode<Integer> root, int x) {
		if(root == null) return 0;
		
		int numNodes = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallAns = numberOfNodesGreaterThanX(root.children.get(i), x);
			numNodes += smallAns;
		}
		
		if(root.data > x) return 1+numNodes;
		else return numNodes;
	}
	
	public static int sumOfNodesInTree(TreeNode<Integer> root) {
		if(root == null) return 0;
		
		int sum = root.data;
		for(int i=0; i<root.children.size(); i++) {
			sum += sumOfNodesInTree(root.children.get(i));
		}
		return sum;
	}
	
	public static boolean checkX(TreeNode<Integer> root, int x) {
		if(root == null) return false;
		
		if(root.data == x) return true;
		
		for(int i=0; i<root.children.size(); i++) {
			boolean isPresent = checkX(root.children.get(i), x);
			if(isPresent) return true;
		}
		
		return false;
	}
	
	public static int sumOfDataOfNodeAndCHildrenIsMax(TreeNode<Integer> root) {  //5* question
		int[] smallAns = sumOfDataOfNodeAndChildrenIsMax2(root);
		return smallAns[1];
	}
	
	public static int[] sumOfDataOfNodeAndChildrenIsMax2(TreeNode<Integer> root) {  //5* question
		
		int sum = root.data;
		int ansNode = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			sum += root.children.get(i).data;
		}
		
		int[] temp = new int[2];
		temp[0] = sum;
		temp[1] = ansNode;
		
		for(int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			int[] smallAns = sumOfDataOfNodeAndChildrenIsMax2(child);
			if(smallAns[0] > temp[0]) {
				temp[0] = smallAns[0];
				temp[1] = smallAns[1];
			}
		}
		
		return temp;
	}
	
	public static boolean structurallyIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		
		if(root1.data != root2.data) return false;
		
		if(root1.children.size() != root2.children.size()) return false;
		
		for(int i=0; i<root1.children.size(); i++) {
			if(!(structurallyIdentical(root1.children.get(i), root2.children.get(i)))) return false;
		}
		
		return true;
	}
	
	public static void replaceNodeWithDepth(TreeNode<Integer> root, int depth) {
		root.data = depth;
		
		/*Root will never become null during the course of recurssion because if root doesn't
		 * have any children then below for loop will never start running
		 */
		
		for(int i=0; i<root.children.size(); i++) { 
			replaceNodeWithDepth(root.children.get(i), depth+1);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TreeNode<Integer> root = takeInputLevelWise();
		
	}
}
