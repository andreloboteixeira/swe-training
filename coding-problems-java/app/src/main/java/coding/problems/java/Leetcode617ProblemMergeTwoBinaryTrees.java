package coding.problems.java;

import java.util.*;

public class Leetcode617ProblemMergeTwoBinaryTrees{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        TreeNode ex1Root1 = new TreeNode(1);
        ex1Root1.left = new TreeNode(3);
        ex1Root1.left.left = new TreeNode(5);

        ex1Root1.right = new TreeNode(2);

        TreeNode ex1Root2 = new TreeNode(2);
        ex1Root2.left = new TreeNode(1);
        ex1Root2.left.right = new TreeNode(4);

        ex1Root2.right = new TreeNode(3);
        ex1Root2.right.right = new TreeNode(7);

        TreeNode ex1Merged = Leetcode617ProblemMergeTwoBinaryTrees.mergeTrees(ex1Root1, ex1Root2);
        Leetcode617ProblemMergeTwoBinaryTrees.printTreeDfs(ex1Merged);

        System.out.println("------ EXAMPLE 2");
        TreeNode ex2Root1 = new TreeNode(1);

        TreeNode ex2Root2 = new TreeNode(1);
        ex2Root2.right = new TreeNode(2);

        TreeNode ex2Merged = Leetcode617ProblemMergeTwoBinaryTrees.mergeTrees(ex2Root1, ex2Root2);
        Leetcode617ProblemMergeTwoBinaryTrees.printTreeDfs(ex2Merged);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return Leetcode617ProblemMergeTwoBinaryTrees.mergeTreesRecurse(root1, root2);
    }

    public static TreeNode mergeTreesRecurse(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 != null && root2 == null) return root1;
        if(root1 == null && root2 != null) return root2;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = Leetcode617ProblemMergeTwoBinaryTrees.mergeTreesRecurse(root1.left, root2.left);
        merged.right = Leetcode617ProblemMergeTwoBinaryTrees.mergeTreesRecurse(root1.right, root2.right);

        return merged;
    }

    // t: O(?), s: O(?)
//    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
////        if(root1 == null && root2 == null) return null;
////        if(root1 != null && root2 == null) return root1;
////        if(root1 == null && root2 != null) return root2;
////
////        TreeNode mergedRoot = new TreeNode(0);
////        TreeNode curr = mergedRoot;
//
//        TreeNode mergedRoot = new TreeNode(0);
//        TreeNode curr = mergedRoot;
//
//        List<TreeNode> queue = new ArrayList<>();
//        queue.add(root1);
//        queue.add(root2);
//
//        int i = 0;
//        while(!queue.isEmpty()){
//            i = i % 3;
//            TreeNode currRoot1 = queue.remove(0);
//            TreeNode currRoot2 = queue.remove(0);
//
//            TreeNode merged = new TreeNode(0);
//
//            if(currRoot1 == null) merged.val = currRoot2.val;
//            if(currRoot2 == null) merged.val = currRoot1.val;
//
//            // add merged node  to the new tree
//
//            queue.add(currRoot1.left);
//            queue.add(currRoot1.right);
//        }
//
//        return mergedRoot;
//    }

//    private static TreeNode (TreeNode root1, TreeNode root2)

    private static void printTreeDfs(TreeNode root){
        if(root == null) return;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.remove(0);
            if(curr != null) {
                System.out.println(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            } else {
                System.out.println("null");
            }
        }

    }

}
