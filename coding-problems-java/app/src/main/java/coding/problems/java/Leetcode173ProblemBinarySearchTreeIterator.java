package coding.problems.java;

import java.util.*;
public class Leetcode173ProblemBinarySearchTreeIterator{
    public static void main(String[] args){

        // in order: 4 -> 2 -> 5 -> 1 -> 6 -> 3 -> 7
        // pre order: 1 -> 2 -> 4 -> 5 -> 3 -> 6 -> 7
        // post order: 4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1
        if(args.length == 1 && args[0].equals("traverseOrders")){
            TreeNode root = new TreeNode(1,
                    new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                    new TreeNode(3, new TreeNode(6), new TreeNode(7)));

            Leetcode173ProblemBinarySearchTreeIterator.testTraversingOrders(root);
            return ;
        }

        TreeNode root = new TreeNode(7,
                new TreeNode(3),
                new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next()); // return 3
        System.out.println(bSTIterator.next()); // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 20
        System.out.println(bSTIterator.hasNext()); // return False

    }

    public static void testTraversingOrders(TreeNode root){
        System.out.println("InOrder:");
        Leetcode173ProblemBinarySearchTreeIterator.printInOrder(root);

        System.out.println("\n\nPreOrder:");
        Leetcode173ProblemBinarySearchTreeIterator.printPreOrder(root);

        System.out.println("\n\nPostOrder:");
        Leetcode173ProblemBinarySearchTreeIterator.printPostOrder(root);
    }

    public static void printInOrder(TreeNode node){
        if(node == null) return ;

        Leetcode173ProblemBinarySearchTreeIterator.printInOrder(node.left);
        System.out.printf("\n Node: %d", node.val);
        Leetcode173ProblemBinarySearchTreeIterator.printInOrder(node.right);
    }

    public static void printPreOrder(TreeNode node){
        if(node == null) return ;

        System.out.printf("\n Node: %d", node.val);
        Leetcode173ProblemBinarySearchTreeIterator.printPreOrder(node.left);
        Leetcode173ProblemBinarySearchTreeIterator.printPreOrder(node.right);
    }

    public static void printPostOrder(TreeNode node){
        if(node == null) return ;

        Leetcode173ProblemBinarySearchTreeIterator.printPostOrder(node.left);
        Leetcode173ProblemBinarySearchTreeIterator.printPostOrder(node.right);
        System.out.printf("\n Node: %d", node.val);
    }
}
