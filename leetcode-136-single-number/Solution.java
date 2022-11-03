public class Solution {
//    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//    You must implement a solution with a linear runtime complexity and use only constant extra space.
//    Example 1:
//
//    Input: nums = [2,2,1]
//    Output: 1
//    Example 2:
//
//    Input: nums = [4,1,2,1,2]
//    Output: 4
//    Example 3:
//
//    Input: nums = [1]
//    Output: 1
//
//
//    Constraints:
//
//            1 <= nums.length <= 3 * 104
//            -3 * 104 <= nums[i] <= 3 * 104
//    Each element in the array appears twice except for one element which appears only once.


    public static void main(String[] args){
        if(Solution.singleNumber(new int[]{2,2,1}) == 1) {
            System.out.println("Ex 1 RIGHT");
        } else {
            System.out.println("Ex 1 WRONG");
        }

        if(Solution.singleNumber(new int[]{4,1,2,1,2}) == 4) {
            System.out.println("Ex 2 RIGHT");
        } else {
            System.out.println("Ex 2 WRONG");
        }

        if(Solution.singleNumber(new int[]{1}) == 1) {
            System.out.println("Ex 3 RIGHT");
        } else {
            System.out.println("Ex 3 WRONG");
        }

        if(Solution.singleNumber(new int[]{-1}) == -1) {
            System.out.println("Ex 4 RIGHT");
        } else {
            System.out.println("Ex 4 WRONG");
        }

    }

    // t: O(n) + O(n) = O(n), s: O(possible values)
    public static int singleNumber(int[] nums){
        // we know constraints, use an array of 2*3*10^4 spaces to store frequency
        // when storing frequencies, should shift 3*10000 as there are negative numbers
        int shift = 3*10000;
        int[] freq = new int[2*shift + 1];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            freq[nums[i] + shift]++;
        }
        for(int i = 0; i < nums.length; i++) {
            if(freq[nums[i] + shift] == 1){
                res = nums[i];
                break;
            }
        }
        return res;

        // solution of xor: xor is cumutative and A^A = 0, B^0 = B, so the remaining number will be the single one
//        int result = 0;
//        for(int i=0;i<nums.length;i++){
//            result = result ^ nums[i];
//        }
//        return result;
    }

}