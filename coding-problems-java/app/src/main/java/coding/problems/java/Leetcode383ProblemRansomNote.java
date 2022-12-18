package coding.problems.java;

import java.util.*;
public class Leetcode383ProblemRansomNote{

//    Given two strings ransomNote and magazine,
//    return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//    Each letter in magazine can only be used once in ransomNote.

//    Constraints:
//
//    1 <= ransomNote.length, magazine.length <= 10^5
//    ransomNote and magazine consist of lowercase English letters.

    public static void main(String[] args){
        if(Leetcode383ProblemRansomNote.canConstruct("a","b") == false) System.out.println("Ex1 correct");
        if(Leetcode383ProblemRansomNote.canConstruct("aa", "ab") == false) System.out.println("Ex2 correct");
        if(Leetcode383ProblemRansomNote.canConstruct("aa", "aab") == true) System.out.println("Ex3 correct");

    }

    // t: O(max(m,n)), s: O(1)
    public static boolean canConstruct(String ransomNote, String magazine) {
        // count freq in magazine
        int[] freq = new int[26];
        for(int i = 0; i < magazine.length(); i++) freq[magazine.charAt(i) - 'a']++;

        // traverse ransom note checking if we have char to be used and decrementing freq if is
        for(int i = 0; i < ransomNote.length(); i++){
            char curr = ransomNote.charAt(i);
            if(freq[curr - 'a'] > 0){
                freq[curr - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
