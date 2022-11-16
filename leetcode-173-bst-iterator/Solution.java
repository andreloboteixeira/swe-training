import java.util.*;
public class Solution{
    public static void main(String[] args){

        // in order: 4 -> 2 -> 5 -> 1 -> 6 -> 3 -> 7
        // pre order: 1 -> 2 -> 4 -> 5 -> 3 -> 6 -> 7
        // post order: 4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        Solution.testTraversingOrders(root);

    }

    public static void testTraversingOrders(TreeNode root){
        System.out.println("InOrder:");
        Solution.printInOrder(root);

        System.out.println("\n\nPreOrder:");
        Solution.printPreOrder(root);

        System.out.println("\n\nPostOrder:");
        Solution.printPostOrder(root);
    }

    public static void printInOrder(TreeNode node){
        if(node == null) return ;

        this.printInOrder(node.left);
        System.out.printf("\n Node: %d", node.val);
        this.printInOrder(node.right);
    }

    public static void printPreOrder(TreeNode node){
        if(node == null) return ;

        System.out.printf("\n Node: %d", node.val);
        this.printPreOrder(node.left);
        this.printPreOrder(node.right);
    }

    public static void printPostOrder(TreeNode node){
        if(node == null) return ;

        this.printPostOrder(node.left);
        this.printPostOrder(node.right);
        System.out.printf("\n Node: %d", node.val);
    }
}
