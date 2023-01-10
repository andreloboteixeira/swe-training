package coding.problems.java;

import java.util.*;

public class Leetcode557ProblemReverseWordsInAStringIII{

    public static void main(String[] args) {

        System.out.println("------ EXAMPLE 1");
        String ex1Input = "Let's take LeetCode contest";
        String ex1ExpectedRes = "s'teL ekat edoCteeL tsetnoc";

        System.out.println("Expected result: ");
        System.out.println(ex1ExpectedRes);

        System.out.println("\nMy solution: ");
        System.out.println(Leetcode557ProblemReverseWordsInAStringIII.reverseWords(ex1Input));

        System.out.println("------ EXAMPLE 2");
        String ex2Input = "God Ding";
        String ex2ExpectedRes = "doG gniD";

        System.out.println("Expected result: ");
        System.out.println(ex2ExpectedRes);

        System.out.println("\nMy solution: ");
        System.out.println(Leetcode557ProblemReverseWordsInAStringIII.reverseWords(ex2Input));

    }

    // t: O(?), s: O(?)
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == ' ' || i == s.length() - 1){
                // new word
                if(i == s.length() - 1) word.append(curr);
                res.append(Leetcode557ProblemReverseWordsInAStringIII.reverseWord(word.toString()));
                word.setLength(0);
                if(i != s.length() - 1){
                    res.append(" ");
                }
            } else {
                word.append(curr);
            }

        }
        return res.toString();
    }

    public static String reverseWord(String s){
        if(s.length() <= 1) return s;
        StringBuilder newWord = new StringBuilder(s);

        int start = 0, end = s.length() - 1;
        while(start < end){
            char aux = s.charAt(start);
            newWord.setCharAt(start, s.charAt(end));
            newWord.setCharAt(end, aux);
            start++;
            end--;
        }
        return newWord.toString();
    }

}
