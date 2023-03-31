package binaryTree;

import dataStructures.EmptyQueueException;
import dataStructures.QueueUsingLLGenericImplementation;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;
    
    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
        if(root == null) return false;

        if(root.data == data) return true;

        /* In the below two line calling both left and right is increasing the work
         * We don't need to call on both sides .. We can just check the data of the root 
         * and compare it with the given data to find is it bigger or smaller and hence calling 
         * on that side.
         * 
         *  if(root.data == data) return true;
            else if(root.data > data) return hasDataHelper(data, root.left);
            else return hasDataHelper(data, root.right);
         * 
         */

        if(root.left != null) return hasDataHelper(data, root.left);
        if(root.right != null) return hasDataHelper(data, root.right);

        return false;
    }

    public boolean hasData2(int data) {  //Internally using a recurssive function
        return hasDataHelper(data, root);
    }

    public boolean hasData(int data) {  //Iterative Method
        if(root == null) return false;

        // if(root.data == data) return true;

        QueueUsingLLGenericImplementation<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLLGenericImplementation<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode;
            try {
                frontNode = pendingNodes.dequeue();
            } catch (EmptyQueueException e) {
                return false;
            }

            if(frontNode.data == data) return true;
            if(frontNode.left != null) pendingNodes.enqueue(frontNode.left);
            if(frontNode.right != null) pendingNodes.enqueue(frontNode.right);
        }

        return false;
    }

}
