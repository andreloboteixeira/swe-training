import java.util.*;
public class Solution{
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
        ex1Res = Solution.sortedSquares(ex1Input);
        System.out.println("ex1 my anwer: ");
        System.out.println(Arrays.toString(ex1Res));


        int[] ex2Input = new int[]{-7,-3,2,3,11};
        int[] ex2Expected = new int[]{4,9,9,49,121};
        int[] ex2Res = new int[ex2Input.length];

        System.out.println("ex2Expected: ");
        System.out.println(Arrays.toString(ex2Expected));
        ex2Res = Solution.sortedSquares(ex2Input);
        System.out.println("ex2 my anwer: ");
        System.out.println(Arrays.toString(ex2Res));
    }

    // t: O(n) + O(nlogn) => O(nlogn), s: O(n)
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            res[i] = nums[i]*nums[i];
        }

        Arrays.sort(res);

        return res;
    }
}
