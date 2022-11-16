import java.util.*;

// t: O(n) to build the inorder, O(1) for each method by just accessing the array
// s: O(n) to store the array and pointer
class BSTIterator {

    int pointer;
    List<Integer> inorder;

    public BSTIterator(TreeNode root) {
        this.inorder = new ArrayList<Integer>();
        this.buildInorderArray(root);
        this.pointer = 0;
    }

    public void buildInorderArray(TreeNode node){
        if(node == null) return ;

        this.buildInorderArray(node.left);
        this.inorder.add(node.val);
        this.buildInorderArray(node.right);
    }

    public int next() {
        int val = this.inorder.get(this.pointer);
        this.pointer++;
        return val;
    }

    public boolean hasNext() {
        return this.pointer < this.inorder.size();
    }

}