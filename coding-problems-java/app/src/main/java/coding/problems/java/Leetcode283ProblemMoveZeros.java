package coding.problems.java;

import java.util.*;

public class Leetcode283ProblemMoveZeros{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        int[] ex1Input = new int[]{0,1,0,3,12};
        int[] ex1ExpectedRes = new int[]{1,3,12,0,0};
        Leetcode283ProblemMoveZeros.moveZeroes(ex1Input);

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex1ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(ex1Input));

        System.out.println("------ EXAMPLE 2");
        int[] ex2Input = new int[]{0};
        int[] ex2ExpectedRes = new int[]{0};
        Leetcode283ProblemMoveZeros.moveZeroes(ex2Input);

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex2ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(ex2Input));

        System.out.println("------ EXAMPLE 3");
        int[] ex3Input = new int[]{1, 0};
        int[] ex3ExpectedRes = new int[]{1, 0};
        Leetcode283ProblemMoveZeros.moveZeroes(ex3Input);

        System.out.println("Expected result: ");
        System.out.println(Arrays.toString(ex3ExpectedRes));

        System.out.println("\nMy solution: ");
        System.out.println(Arrays.toString(ex3Input));
    }

    // t: O(N), s: O(1)
    public static void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return ;

        int currFirstZeroPos = -1;
        int zerosFound = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zerosFound++;
                if (zerosFound == 1) currFirstZeroPos = i;

            } else {
                if(zerosFound != 0){
                    nums[currFirstZeroPos] = nums[i];
                    nums[i] = 0;
                    currFirstZeroPos++;
                }
            }
        }
    }

}
