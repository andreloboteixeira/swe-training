package data.structures.java.binarytree;

public class BinaryTree {
    TreeNode root;

    BinaryTree(){
        this.root = null;
    }

    BinaryTree(TreeNode root){
        this.root = root;
    }

    public void insertNode(int newVal){
        this.root = this.insertNodeRecursive(newVal, this.root);
    }

    public boolean containsNode(int val){
        return this.containsNodeRecursive(val, this.root);
    }

    public void deleteNode(int val){
        this.root = this.deleteNodeRecursive(val, this.root);
    }

    public void printPreorder(){
        this.printPreorderRecursive(this.root);
    }

    public void printInorder(){
        this.printInorderRecursive(this.root);
    }

    public void printPostorder(){
        this.printPostorderRecursive(this.root);
    }

    private TreeNode insertNodeRecursive(int newVal, TreeNode currNode){
        if(currNode == null) return new TreeNode(newVal);

        if(newVal < currNode.val){
            currNode.left = this.insertNodeRecursive(newVal, currNode.left);
        } else if(newVal > currNode.val) {
            currNode.right = this.insertNodeRecursive(newVal, currNode.right);
        } else {
            return currNode;
        }

        return currNode;
    }

    private boolean containsNodeRecursive(int targetVal, TreeNode currNode){
        if(currNode == null) return false;
        if(targetVal == currNode.val) return true;
        return targetVal < currNode.val ?
                this.containsNodeRecursive(targetVal, currNode.left) :
                this.containsNodeRecursive(targetVal, currNode.right);
    }

    private TreeNode deleteNodeRecursive(int val, TreeNode currNode){
        if(currNode == null) return null;

        if(val < currNode.val){
            currNode.left = this.deleteNodeRecursive(val, currNode.left);
            return currNode;
        } else if(val > currNode.val){
            currNode.right = this.deleteNodeRecursive(val, currNode.right);
            return currNode;
        } else {
            // deleted node both child null, one child not null, or both not null
            if(currNode.left == null && currNode.right == null) return null;
            if(currNode.left == null) return currNode.right;
            if(currNode.right == null) return currNode.left;

            if(currNode.left != null && currNode.right != null){
                TreeNode toReplace = this.findSmallestNode(currNode.right);
                currNode.val = toReplace.val;
                currNode.right = this.deleteNodeRecursive(toReplace.val, currNode.right);
                return currNode;
            }
        }
        return currNode;
    }

    private TreeNode findSmallestNode(TreeNode node){
        return node.left != null ? this.findSmallestNode(node.left) : node;
    }

    private void printPreorderRecursive(TreeNode node){
        if(node == null) return ;

        System.out.printf("%d, ", node.val);
        this.printPreorderRecursive(node.left);
        this.printPreorderRecursive(node.right);
    }

    private void printInorderRecursive(TreeNode node){
        if(node == null) return ;

        this.printInorderRecursive(node.left);
        System.out.printf("%d, ", node.val);
        this.printInorderRecursive(node.right);
    }

    private void printPostorderRecursive(TreeNode node){
        if(node == null) return ;

        this.printPostorderRecursive(node.left);
        this.printPostorderRecursive(node.right);
        System.out.printf("%d, ", node.val);
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}