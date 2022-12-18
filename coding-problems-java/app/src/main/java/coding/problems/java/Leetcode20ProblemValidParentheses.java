package coding.problems.java;

import java.util.*;
public class Leetcode20ProblemValidParentheses{
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
//    determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
//
//    Constraints:
//
//    1 <= s.length <= 10^4
//    s consists of parentheses only '()[]{}'.

    public static void main(String[] args){
        if(Leetcode20ProblemValidParentheses.isValid("()") == true) System.out.println("Ex1 correct");
        if(Leetcode20ProblemValidParentheses.isValid("()[]{}") == true) System.out.println("Ex2 correct");
        if(Leetcode20ProblemValidParentheses.isValid("(]") == false) System.out.println("Ex3 correct");
        if(Leetcode20ProblemValidParentheses.isValid("){") == false) System.out.println("Ex4 correct");

    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '(' || currChar == '[' || currChar == '{'){
                stack.push(currChar);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.peek();
                if((top == '(' && currChar == ')') || (top == '[' && currChar == ']') || (top == '{' && currChar == '}')) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }

    }

}
