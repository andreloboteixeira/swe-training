import java.util.*;
public class Solution{
    public static void main(String[] args){
        TreeNode ex1Root = new TreeNode(1,
                                        null, new TreeNode(2,
                                                    new TreeNode(3), null));


        System.out.println("Ex1 my solution");
        for(Integer val: Solution.preorderTraversal(ex1Root))
            System.out.printf("%d, ", val);


        TreeNode ex2Root = null;
        System.out.println("\n\nEx2 my solution");
        for(Integer val: Solution.preorderTraversal(ex2Root))
            System.out.printf("%d, ", val);

        TreeNode ex3Root = new TreeNode(1);
        System.out.println("\n\nEx3 my solution");
        for(Integer val: Solution.preorderTraversal(ex3Root))
            System.out.printf("%d, ", val);

        TreeNode ex4Root = new TreeNode(1,
                                    new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                                    new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println("\n\nEx4 my solution");
        for(Integer val: Solution.preorderTraversal(ex4Root))
            System.out.printf("%d, ", val);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Solution.helper(root, res);

        return res;
    }

    public static void helper(TreeNode node, List<Integer> res){
        if(node == null) return ;

        res.add(node.val);
        Solution.helper(node.left, res);
        Solution.helper(node.right, res);

    }
}
