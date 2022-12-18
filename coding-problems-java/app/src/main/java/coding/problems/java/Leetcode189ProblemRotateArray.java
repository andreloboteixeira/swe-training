package coding.problems.java;

import java.util.*;
public class Leetcode189ProblemRotateArray{
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

        Leetcode189ProblemRotateArray.rotate(ex1Input, 3);

        System.out.println("Ex1 my solution:");
        System.out.println(Arrays.toString(ex1Input));

        int[] ex2Input = new int[]{-1,-100,3,99};

        System.out.println("Ex2 expected:");
        System.out.println(Arrays.toString(new int[]{3,99,-1,-100}));

        Leetcode189ProblemRotateArray.rotate(ex2Input, 2);
        System.out.println("Ex2 my solution:");
        System.out.println(Arrays.toString(ex2Input));

    }

    // reversing 3 times O(n) => O(n) , s: O(1)
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return ;

        Leetcode189ProblemRotateArray.reverse(nums, 0, nums.length - 1);
        Leetcode189ProblemRotateArray.reverse(nums, 0, k - 1);
        Leetcode189ProblemRotateArray.reverse(nums, k, nums.length - 1);

        return ;
    }

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}
