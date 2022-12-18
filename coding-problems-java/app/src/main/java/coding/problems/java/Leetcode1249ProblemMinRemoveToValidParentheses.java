package coding.problems.java;

import java.util.*;

public class Leetcode1249ProblemMinRemoveToValidParentheses{
//    Given a string s of '(' , ')' and lowercase English characters.
//
//    Your task is to remove the minimum number of parentheses ( '(' or ')',
//    in any positions ) so that the resulting parentheses string is valid and return any valid string.
//
//    Formally, a parentheses string is valid if and only if:
//
//    It is the empty string, contains only lowercase characters, or
//    It can be written as AB (A concatenated with B), where A and B are valid strings, or
//    It can be written as (A), where A is a valid string.
//
//
//    Example 1:
//
//    Input: s = "lee(t(c)o)de)"
//    Output: "lee(t(c)o)de"
//    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

//    Example 2:
//
//    Input: s = "a)b(c)d"
//    Output: "ab(c)d"
//    Example 3:
//
//    Input: s = "))(("
//    Output: ""
//    Explanation: An empty string is also valid.
//
//
//    Constraints:
//
//    1 <= s.length <= 105
//    s[i] is either'(' , ')', or lowercase English letter.


    public static void main(String[] args){
        String resEx1 = Leetcode1249ProblemMinRemoveToValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println("Ex1 my res: ");
        System.out.println(resEx1);
        if(resEx1.equals("lee(t(c)o)de")){
            System.out.println("Ex1 correct");
        }

        String resEx2 = Leetcode1249ProblemMinRemoveToValidParentheses.minRemoveToMakeValid("a)b(c)d");
        System.out.println("Ex2 my res: ");
        System.out.println(resEx2);
        if(resEx2.equals("ab(c)d")){
            System.out.println("Ex2 correct");
        }

        String resEx3 = Leetcode1249ProblemMinRemoveToValidParentheses.minRemoveToMakeValid("))((");
        System.out.println("Ex3 my res: ");
        System.out.println(resEx3);
        if(resEx3.equals("")){
            System.out.println("Ex3 correct");
        }
    }

    // t: O(n) + O(n) + O(n) = O(n), s: O(n) + O(n) = O(n)
    public static String minRemoveToMakeValid(String s) {
        char open = '(', closed = ')';

        Stack<Integer> stackOpenIdx = new Stack<Integer>();
        Set<Integer> invalidIdx = new HashSet<Integer>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);

            if(curChar == open){
                stackOpenIdx.push(i);
            } else if(curChar == closed){
                if(!stackOpenIdx.isEmpty()) {
                    stackOpenIdx.pop();
                } else {
                    invalidIdx.add(i);
                }
            }
        }

        while(!stackOpenIdx.isEmpty()){
            invalidIdx.add(stackOpenIdx.peek());
            stackOpenIdx.pop();
        }

        for(int i = 0; i < s.length(); i++){
            if(!invalidIdx.contains(i)) res.append(s.charAt(i));
        }

        return res.toString();
    }
}
