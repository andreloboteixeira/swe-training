import java.util.*;
public class Solution{
//    Constraints:
//    1 <= nums.length <= 104
//    -104 < nums[i], target < 104
//    All the integers in nums are unique.
//    nums is sorted in ascending order.
    public static void main(String[] args){

        if(Solution.search(new int[]{-1,0,3,5,9,12}, 9) == 4){
            System.out.println("Ex1 correct");
        }

        if(Solution.search(new int[]{-1,0,3,5,9,12}, 2) == -1){
            System.out.println("Ex2 correct");
        }

    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;

        while(start <= end){
            mid = start + (end - start)/2;

            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
