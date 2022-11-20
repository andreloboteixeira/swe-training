import java.util.*;
public class Solution{
//    Given a sorted array of distinct integers and a target value,
//    return the index if the target is found. If not,
//    return the index where it would be if it were inserted in order.
//
//    You must write an algorithm with O(log n) runtime complexity.

    public static void main(String[] args){
        if(Solution.searchInsert(new int[]{1,3,5,6}, 5) == 2){
            System.out.println("Ex1 correct");
        }

        if(Solution.searchInsert(new int[]{1,3,5,6}, 2) == 1){
            System.out.println("Ex2 correct");
        }

        if(Solution.searchInsert(new int[]{1,3,5,6}, 7) == 4){
            System.out.println("Ex3 correct");
        }

        if(Solution.searchInsert(new int[]{1,3,5,6}, 0) == 0){
            System.out.println("Ex4 correct");
        }

    }

    // t: O(logn), s: O(1)
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, insert = -1, mid = -1;

        while(start <= end){
            mid = start + (end - start)/2;

            if(target == nums[mid]){
                insert = mid;
                break;
            } else if(target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(insert == -1) {
            if(target < nums[mid]) insert = mid;
            if(target > nums[mid]) insert = mid + 1;
        }

        return insert;
    }
}
