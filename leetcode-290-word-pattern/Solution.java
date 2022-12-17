import java.util.*;
public class Solution{
//    Given a pattern and a string s,
//    find if s follows the same pattern.
//
//    Here follow means a full match,
//    such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//    Example 1:
//
//    Input: pattern = "abba", s = "dog cat cat dog"
//    Output: true
//
//    Example 2:
//
//    Input: pattern = "abba", s = "dog cat cat fish"
//    Output: false
//
//    Example 3:
//
//    Input: pattern = "aaaa", s = "dog cat cat dog"
//    Output: false
//
//    Constraints:
//
//    1 <= pattern.length <= 300
//    pattern contains only lower-case English letters.
//    1 <= s.length <= 3000
//    s contains only lowercase English letters and spaces ' '.
//    s does not contain any leading or trailing spaces.
//    All the words in s are separated by a single space.

    public static void main(String[] args){
        if(Solution.wordPattern("abba", "dog cat cat dog") == true) System.out.println("ex1 correct");
        if(Solution.wordPattern("abba", "dog cat cat fish") == false) System.out.println("ex2 correct");
        if(Solution.wordPattern("aaaa", "dog cat cat dog") == false) System.out.println("ex3 correct");
        if(Solution.wordPattern("abba", "dog dog dog dog") == false) System.out.println("ex4 correct");

    }

    public static boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        HashMap<Character, String> charToWord = new HashMap<Character, String>();

        for(int i = 0; i < pattern.length(); i++){
            char currChar = pattern.charAt(i);
            if(charToWord.containsKey(currChar)){
                String mappedWord = charToWord.get(currChar);
                if(!mappedWord.equals(words[i])) return false;

            } else{
                if(charToWord.containsValue(words[i])) return false;
                charToWord.put(currChar, words[i]);

            }

        }
        return true;

    }
}
