package coding.problems.java;

import java.util.*;
public class Leetcode94ProblemBinaryTreeInorderTraversal{
    public static void main(String[] args){
        TreeNode ex1Root = new TreeNode(1,
                null, new TreeNode(2,
                new TreeNode(3), null));


        System.out.println("Ex1 my solution");
        for(Integer val: Leetcode94ProblemBinaryTreeInorderTraversal.inorderTraversal(ex1Root))
            System.out.printf("%d, ", val);


        TreeNode ex2Root = null;
        System.out.println("\n\nEx2 my solution");
        for(Integer val: Leetcode94ProblemBinaryTreeInorderTraversal.inorderTraversal(ex2Root))
            System.out.printf("%d, ", val);

        TreeNode ex3Root = new TreeNode(1);
        System.out.println("\n\nEx3 my solution");
        for(Integer val: Leetcode94ProblemBinaryTreeInorderTraversal.inorderTraversal(ex3Root))
            System.out.printf("%d, ", val);

        TreeNode ex4Root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println("\n\nEx4 my solution");
        for(Integer val: Leetcode94ProblemBinaryTreeInorderTraversal.inorderTraversal(ex4Root))
            System.out.printf("%d, ", val);

    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;

        Leetcode94ProblemBinaryTreeInorderTraversal.helper(root, inorder);
        return inorder;
    }

    public static void helper(TreeNode node, List<Integer> inorder){
        if(node == null) return ;

        Leetcode94ProblemBinaryTreeInorderTraversal.helper(node.left, inorder);
        inorder.add(node.val);
        Leetcode94ProblemBinaryTreeInorderTraversal.helper(node.right, inorder);
    }
}
