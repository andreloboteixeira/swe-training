package coding.problems.java;

import java.util.*;
public class Leetcode53MaximumSubarray{
    public static void main(String[] args){
        if(Leetcode53MaximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6){
            System.out.println("Ex1 correct");
        }

        if(Leetcode53MaximumSubarray.maxSubArray(new int[]{1}) == 1){
            System.out.println("Ex2 correct");
        }

        if(Leetcode53MaximumSubarray.maxSubArray(new int[]{5,4,-1,7,8}) == 23){
            System.out.println("Ex3 correct");
        }

    }

    // t: O(n) using Kadane's algorithm, s: O(1)
    public static int maxSubArray(int[] nums) {
        // S(i) is the sum from [0, i]
        // S(j) - S(i-1) is the sum from [i,j]
        // we should find i and j that maximizes S(j) - S(i-1), that is

        int largestSumSoFar = Integer.MIN_VALUE;
        int currSum = 0;
        int iFinal = 0, jFinal = 0;
        int iCurr = 0, jCurr = 0;
        for(int i = 0; i < nums.length; i++){
            if(currSum + nums[i] < nums[i]){
                currSum = nums[i];
                iCurr = i;
                jCurr = i;
            } else {
                currSum = currSum + nums[i];
                jCurr = i;
            }

            if(currSum > largestSumSoFar){
                largestSumSoFar = currSum;
                iFinal = iCurr;
                jFinal = jCurr;
            }

        }
        System.out.printf("[i,j] = [%d %d]", iFinal, jFinal);

        return largestSumSoFar;
    }
}
