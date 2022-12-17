import java.util.*;
public class Solution{
//    Given two strings s and t,
//    return true if t is an anagram of s,
//    and false otherwise.
//
//    An Anagram is a word or phrase formed by rearranging
//    the letters of a different word or phrase,
//    typically using all the original letters exactly once.
//
//    Constraints:
//
//    1 <= s.length, t.length <= 5 * 10^4
//    s and t consist of lowercase English letters.
//
//    Follow up: What if the inputs contain Unicode characters?
//    How would you adapt your solution to such a case?

    public static void main(String[] args){
        if(Solution.isAnagram("anagram", "nagaram") == true) System.out.println("Ex1 correct");

        if(Solution.isAnagram("rat", "car") == false) System.out.println("Ex2 correct");

        if(Solution.isAnagram("ratata", "tarata") == true) System.out.println("Ex3 correct");

        if(Solution.isAnagram("", "") == true) System.out.println("Ex4 correct");

        if(Solution.isAnagram("a", "") == false) System.out.println("Ex5 correct");
    }

    // t: O(m + n + const) = O(max(m,n)), s: O(1)
    // if using unicode chars, we could use a hash map instead as we have many more elements so we don't have allocate a huge array
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        for(int j = 0; j < t.length(); j++){
            freq[t.charAt(j) - 'a']--;
            if(freq[t.charAt(j) - 'a'] < 0) return false;
        }

        for(int k = 0; k < 26; k++){
            if(freq[k] != 0) return false;
        }
        return true;
    }
}
