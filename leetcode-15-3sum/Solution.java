import java.util.*;

public class Solution {
//    Given an integer array nums,
//    return all the triplets [nums[i], nums[j], nums[k]] such that
//    i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//    Notice that the solution set must not contain duplicate triplets.
//
//    Example 1:
//
//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]
//    Explanation:
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//    The distinct triplets are [-1,0,1] and [-1,-1,2].
//    Notice that the order of the output and the order of the triplets does not matter.
//
//    Example 2:
//
//    Input: nums = [0,1,1]
//    Output: []
//    Explanation: The only possible triplet does not sum up to 0.
//
//    Example 3:
//
//    Input: nums = [0,0,0]
//    Output: [[0,0,0]]
//    Explanation: The only possible triplet sums up to 0.
//
//
//    Constraints:
//
//    3 <= nums.length <= 3000
//    -10^5 <= nums[i] <= 10^5

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        int[] ex1Input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ex1ExpectedRes = Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1));
        List<List<Integer>> ex1Res = Solution.threeSum(ex1Input);

        System.out.println("Expected result triplets: ");
        for(List<Integer> triplet: ex1ExpectedRes) {
            System.out.println(triplet);
        }

        System.out.println("\nMy solution triplets: ");
        for(List<Integer> triplet: ex1Res) {
            System.out.println(triplet);
        }

        System.out.println("------ EXAMPLE 2");
        int[] ex2Input = new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        List<List<Integer>> ex2ExpectedRes = Arrays.asList(Arrays.asList(-3,0,3), Arrays.asList(-1,0,1), Arrays.asList(0,0,0));
        List<List<Integer>> ex2Res = Solution.threeSum(ex2Input);

        System.out.println("Expected result triplets: ");
        for(List<Integer> triplet: ex2ExpectedRes) {
            System.out.println(triplet);
        }

        System.out.println("\nMy solution triplets: ");
        for(List<Integer> triplet: ex2Res) {
            System.out.println(triplet);
        }


    }
    // t: O(n.logn) + O(n^2) = O(n^2), s: O(number of triplets) + O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            // find j, k with two-sum sorted approach
            int low = i+1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    resList.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    low++;
                    while(low < high && nums[low] == nums[low-1]) low++;
                } else{
                    if(sum < 0) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }


        return resList;
    }

}