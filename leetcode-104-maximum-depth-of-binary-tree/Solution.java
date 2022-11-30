import java.util.*;
public class Solution{

//    Given the root of a binary tree, return its maximum depth.
//
//    A binary tree's maximum depth is the number of nodes along
//    the longest path from the root node down to the farthest leaf node.

//    Constraints:
//    The number of nodes in the tree is in the range [0, 10^4].
//    -100 <= Node.val <= 100

    public static void main(String[] args){
        TreeNode ex1Root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        if(Solution.maxDepth(ex1Root) == 3) System.out.println("Ex1 correct");

        TreeNode ex2Root = new TreeNode(1, null, new TreeNode(2));
        if(Solution.maxDepth(ex2Root) == 2) System.out.println("Ex2 correct");
    }

    // t: O(n), s: O(1)
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftSize = Solution.maxDepth(root.left);
        int rightSize = Solution.maxDepth(root.right);

        return Integer.max(leftSize, rightSize) + 1;
    }
}
