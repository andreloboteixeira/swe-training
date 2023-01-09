package coding.problems.java;

import java.util.*;

public class Leetcode167ProblemTwoSumII{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        int[] ex1Input = new int[]{2,7,11,15};
        int[] ex1ExpectedRes = new int[]{1, 2};

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex1ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(Leetcode167ProblemTwoSumII.twoSum(ex1Input, 9)));

        System.out.println("------ EXAMPLE 2");
        int[] ex2Input = new int[]{2,3,4};
        int[] ex2ExpectedRes = new int[]{1, 3};

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex2ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(Leetcode167ProblemTwoSumII.twoSum(ex2Input, 6)));

        System.out.println("------ EXAMPLE 3");
        int[] ex3Input = new int[]{-1, 0};
        int[] ex3ExpectedRes = new int[]{1, 2};

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex3ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(Leetcode167ProblemTwoSumII.twoSum(ex3Input, -1)));
    }

    // t: O(?), s: O(?)
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            } else if(sum > target){
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
