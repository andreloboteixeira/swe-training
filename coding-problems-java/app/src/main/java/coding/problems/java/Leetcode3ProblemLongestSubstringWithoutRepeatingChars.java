package coding.problems.java;

import java.util.*;

public class Leetcode3ProblemLongestSubstringWithoutRepeatingChars{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        System.out.println(Leetcode3ProblemLongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("------ EXAMPLE 2");
        System.out.println(Leetcode3ProblemLongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("bbbbb"));
        System.out.println("------ EXAMPLE 3");
        System.out.println(Leetcode3ProblemLongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("pwwkew"));
    }

    // t: O(N), s: O(1)
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int window = 1;
        int left = 0;
        int maxLen = 1;
        while(left + window <= s.length()){
            String curr = s.substring(left, left + window);
            boolean ans = Leetcode3ProblemLongestSubstringWithoutRepeatingChars.areAllDistinct(curr);
            if(ans == true) {
                System.out.println(curr);
                maxLen = Integer.max(maxLen, curr.length());
                window++;
            } else {
                left++;
            }
        }

        return maxLen;
    }

    private static boolean areAllDistinct(String s){
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++;
        }

        for(int i = 0; i < 128; i++){
            if(freq[i] > 1) return false;
        }

        return true;
    }
}



