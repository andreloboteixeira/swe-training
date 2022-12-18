package coding.problems.java;

import java.util.*;

public class Leetcode108ProblemConvertSortedArraryToBinarySearchTree{
//    Given an integer array nums where the elements are sorted in ascending order,
//    convert it to a height-balanced binary search tree.
//
//    Example 1:
//
//    Input: nums = [-10,-3,0,5,9]
//    Output: [0,-3,9,-10,null,5]
//    Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
//
//    Example 2:
//
//    Input: nums = [1,3]
//    Output: [3,1]
//    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
//
//    Constraints:
//
//    1 <= nums.length <= 10^4
//    -10^4 <= nums[i] <= 10^4
//    nums is sorted in a strictly increasing order.

    public static void main(String[] args){

        int[] arrayEx1 = new int[]{-10,-3,0,5,9};

        TreeNode resEx1 = Leetcode108ProblemConvertSortedArraryToBinarySearchTree.sortedArrayToBST(arrayEx1);
        Leetcode108ProblemConvertSortedArraryToBinarySearchTree.printBST(resEx1);

    }

    // t: O(n), s: stack O(logn)
    public static TreeNode sortedArrayToBST(int[] nums) {

        return Leetcode108ProblemConvertSortedArraryToBinarySearchTree.arrToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode arrToBST(int[] arr, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = arrToBST(arr, start, mid - 1);
        node.right = arrToBST(arr, mid + 1, end);

        return node;
    }

    public static void printBST(TreeNode node){
        if(node == null) return ;

        System.out.printf("%d, ", node.val);
        printBST(node.left);
        printBST(node.right);
    }
}
