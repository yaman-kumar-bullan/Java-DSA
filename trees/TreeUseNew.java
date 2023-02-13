package trees;
import java.util.*;

import dataStructures.EmptyQueueException;
import dataStructures.QueueUsingLLGenericImplementation;
import dataStructures.QueueUsingLinkedList;
public class TreeUseNew {

	public static TreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter the next node data : ");
		int rootData = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		System.out.println("Enter no of childrens of " + root.data + " : ");
		int numChild = sc.nextInt();
		
		for(int i=0; i<numChild; i++) {
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
		
		System.out.println("Enter the root data : ");
		int rootData = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		QueueUsingLLGenericImplementation<TreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter no of childrens of " + frontNode.data + " :");
				int numChild = sc.nextInt();
				for(int  i=1; i<=numChild; i++) {
					System.out.println("Enter " + i + "th child of " + frontNode.data + " :");
					int childData = sc.nextInt();
					TreeNode<Integer> child = new TreeNode<>(childData);
					frontNode.children.add(child);
					pendingNodes.enqueue(child);
				}
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				String str = frontNode.data + ":";
				for(int i=0; i<frontNode.children.size(); i++) {
					str = str + frontNode.children.get(i).data + ",";
					pendingNodes.enqueue(frontNode.children.get(i));
				}
				System.out.println(str);
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static int numberOfNodes(TreeNode<Integer> root) {
		if(root == null) return 0;
		
		int count = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			count += numberOfNodes(root.children.get(i));
		}
		
		return count + 1;
	}
	
	public static int nodeWithLargestData(TreeNode<Integer> root) {
		int max = root.data;
		for(int i=0; i<root.children.size(); i++) {
			int rootChild = nodeWithLargestData(root.children.get(i));
			if(rootChild > max) max = rootChild;
		}
		
		return max;
	}
	
	public static int heightOfTree(TreeNode<Integer> root) {
		
		if(root == null) return 0;
		
		int height = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int childTreeHeight = heightOfTree(root.children.get(i));
			if(childTreeHeight > height) height = childTreeHeight;
		}
		
		return height + 1;
	}

	public static void printNodesAtKthDepth(TreeNode<Integer> root, int k) {
		if(k==0) {
			System.out.print(root.data + ",");
			return;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			printNodesAtKthDepth(root.children.get(i), k-1);
		}
	}
	
	public static int numberOfLeafNodes(TreeNode<Integer> root) {
		if(root == null) return 0;
		
		int count = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			count += numberOfLeafNodes(root.children.get(i));
		}
		
		if(count == 0) return 1;
		else return count;
	}
	
	public static void preOrderTraversal(TreeNode<Integer> root) {
		
		System.out.print(root.data + " ");
		
		for(int i=0; i<root.children.size(); i++) {
			preOrderTraversal(root.children.get(i));
		}
	}
	
	public static void postOrderTraversal(TreeNode<Integer> root) {
		for(int i=0; i<root.children.size(); i++) {
			postOrderTraversal(root.children.get(i));
		}
		
		System.out.print(root.data + " ");
	}
	
	public static int numOfNodesGreaterThanX(TreeNode<Integer> root, int x) {
		int count = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			count += numOfNodesGreaterThanX(root.children.get(i), x);
		}
		
		if(root.data > x) return ++count;
		return count;
	}
	
	public static int sumOfNodes(TreeNode<Integer> root) {
		int sum = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			sum += sumOfNodes(root.children.get(i));
		}
		
		return sum;
	}
	
	public static boolean checkX(TreeNode<Integer> root, int x) {
		if(root.data == x) return true;
		
		for(int i=0; i<root.children.size(); i++) {
			if(checkX(root.children.get(i),x)) return true;
		}
		
		return false;
	}
	
	public static int[] sumOfNodeAndChildrenIsMax2(TreeNode<Integer> root) {
		int[] ans = new int[2];
		int sum = root.data;
		for(int i=0; i<root.children.size(); i++) {
			sum += root.children.get(i).data;
		}
		
		ans[0] = sum;  //sum
		ans[1] = root.data; //root node's data
		
		for(int i=0; i<root.children.size(); i++) {
			int[] smallAns = sumOfNodeAndChildrenIsMax2(root.children.get(i));
			if(smallAns[0] > ans[0]) {
				ans[0] = smallAns[0];
				ans[1] = smallAns[1];
			}
		}
		
		return ans;
	}
	
	public static int sumOfNodeAndChildrenIsMax(TreeNode<Integer> root) {
		int[] ans = sumOfNodeAndChildrenIsMax2(root);
		return ans[1];
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
		replaceNodeWithDepth(root, 0);
		printLevelWise(root);
	}
	
}
