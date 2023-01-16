package coding.problems.java;

import java.util.*;

public class Leetcode567ProblemPermutationInString{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        System.out.println(Leetcode567ProblemPermutationInString.checkInclusion("ab", "eidbaooo"));
        System.out.println("------ EXAMPLE 2");
        System.out.println(Leetcode567ProblemPermutationInString.checkInclusion("ab", "eidboaoo"));
    }

    // t: O(?), s: O(?)
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freqS1 = new int[256];
        for(int i = 0; i < s1.length(); i++){
            freqS1[s1.charAt(i)]++;
        }

        int window = s1.length();
        int left = 0;
        while(left + window <= s2.length()){
            String curr = s2.substring(left, left + window);
            if(Leetcode567ProblemPermutationInString.checkFreq(freqS1, curr)){
                return true;
            } else{
                left++;
            }
        }

        return false;
    }

    private static boolean checkFreq(int[] freqS1, String s2){
        int[] freqS2 = new int[256];
        for(int i = 0; i < s2.length(); i++){
            freqS2[s2.charAt(i)]++;
        }

        for(int i = 0; i < 256; i++){
            if(freqS1[i] != freqS2[i]) return false;
        }
        return true;
    }
}
