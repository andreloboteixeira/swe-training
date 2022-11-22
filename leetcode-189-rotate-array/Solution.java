import java.util.*;
public class Solution{
//    Given an array, rotate the array to the right by k steps,
//    where k is non-negative.
//
//    Constraints:
//
//    1 <= nums.length <= 10^5
//    -2^31 <= nums[i] <= 2^31 - 1
//    0 <= k <= 10^5
//    Follow up:
//
//    Try to come up with as many solutions as you can.
//    There are at least three different ways to solve this problem.
//    Could you do it in-place with O(1) extra space?

    public static void main(String[] args){
        int[] ex1Input = new int[]{1,2,3,4,5,6,7};

        System.out.println("Ex1 expected:");
        System.out.println(Arrays.toString(new int[]{5,6,7,1,2,3,4}));

        Solution.rotate(ex1Input, 3);

        System.out.println("Ex1 my solution:");
        System.out.println(Arrays.toString(ex1Input));

        int[] ex2Input = new int[]{-1,-100,3,99};

        System.out.println("Ex2 expected:");
        System.out.println(Arrays.toString(new int[]{3,99,-1,-100}));

        Solution.rotate(ex2Input, 2);
        System.out.println("Ex2 my solution:");
        System.out.println(Arrays.toString(ex2Input));

    }

    // O(n) to copy to left and right + O(n) copy again to original, s: O(n)
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return ;

        int mid = nums.length - k;
        int j = 0;

        int [] right = new int[k];
        for(int i = mid; i < nums.length; i++) {
            right[j++] = nums[i];
        }

        j = 0;
        int [] left = new int[nums.length - k];
        for(int i = 0; i < mid; i++) {
            left[j++] = nums[i];
        }

        j = 0;
        for(int i = 0; i < right.length; i++) {
            nums[j++] = right[i];
        }
        for(int i = 0; i < left.length; i++) {
            nums[j++] = left[i];
        }

        return ;
    }
}
