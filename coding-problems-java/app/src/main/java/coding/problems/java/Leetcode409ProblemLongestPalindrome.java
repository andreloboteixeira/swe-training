package coding.problems.java;

import java.util.*;
public class Leetcode409ProblemLongestPalindrome{
//    Given a string s which consists of lowercase or uppercase letters,
//    return the length of the longest palindrome that can be built with those letters.
//
//    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//    Example 1:
//
//    Input: s = "abccccdd"
//    Output: 7
//    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//    Example 2:
//
//    Input: s = "a"
//    Output: 1
//    Explanation: The longest palindrome that can be built is "a", whose length is 1.
//
//    Constraints:
//
//            1 <= s.length <= 2000
//    s consists of lowercase and/or uppercase English letters only.

    public static void main(String[] args){
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("abccccdd") == 7) System.out.println("Ex1 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("a") == 1) System.out.println("Ex2 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("aAa") == 3) System.out.println("Ex3 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("BBbb") == 4) System.out.println("Ex4 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("bbbbZZacde") == 7) System.out.println("Ex5 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("ccc") == 3) System.out.println("Ex6 correct");
        if(Leetcode409ProblemLongestPalindrome.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth") == 983) System.out.println("Ex7 correct");

    }

    public static int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;

        int counter = 0;
        boolean isThereOdd = false;
        for(int i = 0; i < freq.length; i++){
            if(freq[i]%2 == 1) isThereOdd = true;

            counter+= freq[i]/2 * 2;
        }
        if(isThereOdd) counter++;

        return counter;
    }
}
