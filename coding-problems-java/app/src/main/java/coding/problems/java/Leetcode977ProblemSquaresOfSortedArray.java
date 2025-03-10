package coding.problems.java;

import java.util.*;
public class Leetcode977ProblemSquaresOfSortedArray{
//    Given an integer array nums sorted in non-decreasing order,
//    return an array of the squares of each number sorted in non-decreasing order.

//    Constraints:
//    1 <= nums.length <= 10^4
//    -10^4 <= nums[i] <= 10^4
//    nums is sorted in non-decreasing order.

    public static void main(String[] args){
        int[] ex1Input = new int[]{-4,-1,0,3,10};
        int[] ex1Expected = new int[]{0,1,9,16,100};
        int[] ex1Res = new int[ex1Input.length];

        System.out.println("ex1Expected: ");
        System.out.println(Arrays.toString(ex1Expected));
        ex1Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex1Input);
        System.out.println("ex1 my anwer: ");
        System.out.println(Arrays.toString(ex1Res));


        int[] ex2Input = new int[]{-7,-3,2,3,11};
        int[] ex2Expected = new int[]{4,9,9,49,121};
        int[] ex2Res = new int[ex2Input.length];

        System.out.println("ex2Expected: ");
        System.out.println(Arrays.toString(ex2Expected));
        ex2Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex2Input);
        System.out.println("ex2 my anwer: ");
        System.out.println(Arrays.toString(ex2Res));

        int[] ex3Input = new int[]{-7,-3,-2,-1,0};
        int[] ex3Expected = new int[]{0,1,4,9,49};
        int[] ex3Res = new int[ex3Input.length];

        System.out.println("ex3Expected: ");
        System.out.println(Arrays.toString(ex3Expected));
        ex3Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex3Input);
        System.out.println("ex3 my anwer: ");
        System.out.println(Arrays.toString(ex3Res));

        int[] ex4Input = new int[]{0, 1, 2, 3, 7};
        int[] ex4Expected = new int[]{0,1,4,9,49};
        int[] ex4Res = new int[ex4Input.length];

        System.out.println("ex4Expected: ");
        System.out.println(Arrays.toString(ex4Expected));
        ex4Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex4Input);
        System.out.println("ex4 my anwer: ");
        System.out.println(Arrays.toString(ex4Res));

        int[] ex5Input = new int[]{0, 0, 0, 3, 7};
        int[] ex5Expected = new int[]{0,0,0,9,49};
        int[] ex5Res = new int[ex5Input.length];

        System.out.println("ex5Expected: ");
        System.out.println(Arrays.toString(ex5Expected));
        ex5Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex5Input);
        System.out.println("ex5 my anwer: ");
        System.out.println(Arrays.toString(ex5Res));

        int[] ex6Input = new int[]{-7, -3, 0, 0, 0};
        int[] ex6Expected = new int[]{0,0,0,9,49};
        int[] ex6Res = new int[ex6Input.length];

        System.out.println("ex6Expected: ");
        System.out.println(Arrays.toString(ex6Expected));
        ex6Res = Leetcode977ProblemSquaresOfSortedArray.sortedSquares(ex6Input);
        System.out.println("ex6 my anwer: ");
        System.out.println(Arrays.toString(ex6Res));
    }

    // t: O(n), s: O(n)
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int start = 0, end = nums.length - 1;
        int k = end;

        int leftSquare = 0, rightSquare = 0;
        while(start <= end){
            leftSquare = nums[start]*nums[start];
            rightSquare = nums[end]*nums[end];

            if(leftSquare > rightSquare) {
                res[k] = leftSquare;
                k--;
                start++;
            } else {
                res[k] = rightSquare;
                k--;
                end--;
            }

        }

        return res;
    }
}
