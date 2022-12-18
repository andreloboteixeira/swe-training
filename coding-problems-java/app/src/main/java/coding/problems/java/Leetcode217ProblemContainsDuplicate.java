package coding.problems.java;

import java.util.*;
public class Leetcode217ProblemContainsDuplicate{
    public static void main(String[] args){

        if(Leetcode217ProblemContainsDuplicate.containsDuplicate(new int[]{1,2,3,1}) == true){
            System.out.println("Ex1 correct");

        }

        if(Leetcode217ProblemContainsDuplicate.containsDuplicate(new int[]{1,2,3,4}) == false){
            System.out.println("Ex2 correct");
        }

        if(Leetcode217ProblemContainsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}) == true){
            System.out.println("Ex3 correct");
        }

    }

    // t: O(n) worst case if all elements distinct, s: O(n) worst case if all distinct elements
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> occured = new HashMap<Integer, Boolean>();

        for(int i = 0; i < nums.length; i++){
            if(occured.containsKey(nums[i])){
                return true;
            } else {
                occured.put(nums[i], true);
            }

        }

        return false;
    }
}
