import java.util.*;

public class Solution{
//    Given an array nums with n objects colored red, white, or blue,
//    sort them in-place so that objects of the same color are adjacent,
//    with the colors in the order red, white, and blue.
//
//    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//    You must solve this problem without using the library's sort function.
//
//    Example 1:
//
//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]

//    Example 2:
//
//    Input: nums = [2,0,1]
//    Output: [0,1,2]
//
//
//    Constraints:
//
//    n == nums.length
//    1 <= n <= 300
//    nums[i] is either 0, 1, or 2.
//
//    Follow up: Could you come up with a one-pass algorithm using only constant extra space?

    public static void main(String[] args){
        int[] ex1Input = new int[]{2,0,2,1,1,0};
        int[] ex1ExpectedRes = new int[]{0,0,1,1,2,2};

        System.out.println("\nExpected result: ");
        for(int val: ex1ExpectedRes) {
            System.out.printf("%d, ", val);
        }

        Solution.sortColors(ex1Input);

        System.out.println("\nMy solution:");
        for(int val: ex1Input) {
            System.out.printf("%d, ", val);
        }

        int[] ex2Input = new int[]{2,0,1};
        int[] ex2ExpectedRes = new int[]{0,1,2};

        System.out.println("\nExpected result: ");
        for(int val: ex2ExpectedRes) {
            System.out.printf("%d, ", val);
        }

        Solution.sortColors(ex2Input);

        System.out.println("\nMy solution:");
        for(int val: ex2Input) {
            System.out.printf("%d, ", val);
        }

    }

    // t: O(n) + O(n) = O(n), s: O(1)
    public static void sortColors(int[] nums) {
        int[] freq = new int[3];

        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }

        int i = 0;
        for(int color = 0; color < 3; color++) {
            while(freq[color] > 0){
                nums[i] = color;
                freq[color]--;
                i++;
            }
        }

    }

}