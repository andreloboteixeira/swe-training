import java.util.*;
public class Solution{
//    Given a string s, find the first non-repeating character in it and return its index.
//    If it does not exist, return -1.

//    Constraints:
//    1 <= s.length <= 105
//    s consists of only lowercase English letters.

    public static void main(String[] args){

        if(Solution.firstUniqChar("leetcode") == 0) System.out.println("Ex1 correct");

        if(Solution.firstUniqChar("loveleetcode") == 2) System.out.println("Ex2 correct");

        if(Solution.firstUniqChar("aabb") == -1) System.out.println("Ex3 correct");

    }

    // t: O(n + n) = O(n), s: O(1)
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] <= 1) return i;
        }

        return -1;
    }
}
