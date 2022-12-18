package coding.problems.java;

import java.util.*;
public class Leetcode105ProblemConstructBSTFromPreorderAndInorder{
    public static void main(String[] args){
        TreeNode resEx1 = Leetcode105ProblemConstructBSTFromPreorderAndInorder.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printTree(resEx1);
    }

    public static void printTree(TreeNode root){
        System.out.println("Pre-order");
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printPreorder(root);
        System.out.println("In-order");
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printInorder(root);
    }

    public static void printPreorder(TreeNode node){
        if(node == null) return ;

        System.out.println(node.val);
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printPreorder(node.left);
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printPreorder(node.right);
    }

    public static void printInorder(TreeNode node){
        if(node == null) return ;

        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printInorder(node.left);
        System.out.println(node.val);
        Leetcode105ProblemConstructBSTFromPreorderAndInorder.printInorder(node.right);
    }

    // t: O(n), a function call for every element, function is constant using the inorderMap
    // s: O(n), using the map to save time that would be O(n^2) if a linear search in the helper function was used instead
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = Leetcode105ProblemConstructBSTFromPreorderAndInorder.buildInorderMap(inorder);
        TreeNode root = Leetcode105ProblemConstructBSTFromPreorderAndInorder.helper(preorder, inorderMap, 0, 0, inorder.length - 1);
        return root;
    }

    public static Map<Integer, Integer> buildInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return map;
    }

    public static TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int preStart, int inStart, int inEnd){
        // stop when no root nodes anymore in preorder array or invalid check in inorder array
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        TreeNode newRoot = new TreeNode(preorder[preStart]);

        // find the curent root index in the inorder array
        int mid = inorderMap.get(newRoot.val);
        // the ones at the left of mid belong to the left tree [inStart, mid - 1]
        // the ones at the right of mid belong to the right tree [mid + 1, inEnd]

        // the root node at the left will be created with the next element in the preorder (preorder++)
        // and the left tree found in the inorder array
        newRoot.left = Leetcode105ProblemConstructBSTFromPreorderAndInorder.helper(preorder, inorderMap, preStart + 1, inStart, mid - 1);
        // the root node at the right should be created with the first righ element in preorder,
        // that is, after all left tree elements (preorder + mid - inStart + 1), (mid - inStart) shifts the left tree
        // and the right tree found in the inorder array
        newRoot.right = Leetcode105ProblemConstructBSTFromPreorderAndInorder.helper(preorder, inorderMap, preStart + mid - inStart + 1, mid + 1, inEnd);
        return newRoot;

    }
}
