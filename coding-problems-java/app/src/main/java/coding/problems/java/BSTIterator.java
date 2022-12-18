package coding.problems.java;

import java.util.*;

// t: O(1) in average for next and hasNext, every node will be placed once in stack and next can be called n times.
// Next has to push to the stack in case current visited node has right child
// s: O(h) where h is the tree height, values stored in the stack
class BSTIterator {

    Stack<TreeNode> iterativeDFS;

    public BSTIterator(TreeNode root) {
        this.iterativeDFS = new Stack<TreeNode>();
        this.pushAllLeft(root);
    }

    public void pushAllLeft(TreeNode node){
        TreeNode curr = node;
        while(curr != null) {
            this.iterativeDFS.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        int nextVal = 0;
        if(!this.iterativeDFS.isEmpty()){
            TreeNode curr = this.iterativeDFS.pop();
            nextVal = curr.val;
            if(curr.right != null){
                this.pushAllLeft(curr.right);
            }
        }
        return nextVal;
    }

    public boolean hasNext() {
        return !this.iterativeDFS.isEmpty();
    }

}