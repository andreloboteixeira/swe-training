package coding.problems.java;

import java.util.*;

public class Leetcode1ProblemTwoSum{
//    Given an array of integers nums and an integer target,
//    return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution,
//    and you may not use the same element twice.
//
//    You can return the answer in any order.
    public static void main(String[] args){
        int[] ex1Input = new int[]{2,7,11,15};
        int[] ex1Expected = new int[]{0,1};
        int[] ex1Res = new int[ex1Input.length];

        System.out.println("ex1Expected: ");
        System.out.println(Arrays.toString(ex1Expected));
        ex1Res = Leetcode1ProblemTwoSum.twoSum(ex1Input, 9);
        System.out.println("ex1 my anwer: ");
        System.out.println(Arrays.toString(ex1Res));

        int[] ex2Input = new int[]{3,2,4};
        int[] ex2Expected = new int[]{1,2};
        int[] ex2Res = new int[ex2Input.length];

        System.out.println("ex2Expected: ");
        System.out.println(Arrays.toString(ex2Expected));
        ex2Res = Leetcode1ProblemTwoSum.twoSum(ex2Input, 6);
        System.out.println("ex2 my anwer: ");
        System.out.println(Arrays.toString(ex2Res));

        int[] ex3Input = new int[]{3,3};
        int[] ex3Expected = new int[]{0,1};
        int[] ex3Res = new int[ex3Input.length];

        System.out.println("ex3Expected: ");
        System.out.println(Arrays.toString(ex3Expected));
        ex3Res = Leetcode1ProblemTwoSum.twoSum(ex3Input, 6);
        System.out.println("ex3 my anwer: ");
        System.out.println(Arrays.toString(ex3Res));

    }

    // t: O(n), s: O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> numberIdx = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(numberIdx.containsKey(complement)){
                res[0] = i;
                res[1] = numberIdx.get(complement);
                break;
            } else {
                numberIdx.put(nums[i], i);
            }

        }

        return res;
    }
}
