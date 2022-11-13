import java.util.*;

class Node {
    char val;
    int index;
    public Node(char val, int index){
        this.val = val;
        this.index = index;
    }
}

public class Solution{
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
        String resEx1 = Solution.minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println("Ex1 my res: ");
        System.out.println(resEx1);
        if(resEx1.equals("lee(t(c)o)de")){
            System.out.println("Ex1 correct");
        }

        String resEx2 = Solution.minRemoveToMakeValid("a)b(c)d");
        System.out.println("Ex2 my res: ");
        System.out.println(resEx2);
        if(resEx2.equals("ab(c)d")){
            System.out.println("Ex2 correct");
        }

        String resEx3 = Solution.minRemoveToMakeValid("))((");
        System.out.println("Ex3 my res: ");
        System.out.println(resEx3);
        if(resEx3.equals("")){
            System.out.println("Ex3 correct");
        }
    }

    // t: O(n) + O(n) + O(n) = O(n), s: O(n) + O(n) = O(n)
    public static String minRemoveToMakeValid(String s) {
        char open = '(', closed = ')';

        Stack<Node> stack = new Stack<Node>();
        Set<Integer> invalidIdx = new HashSet<Integer>();
        String res = "";

        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);


            if(curChar == open){
                stack.push(new Node(curChar, i));
            } else if(curChar == closed){
                if(!stack.isEmpty() && stack.peek().val == open) {
                    stack.pop();
                } else {
                    invalidIdx.add(i);
                }
            }
        }

        while(!stack.isEmpty()){
            invalidIdx.add(stack.peek().index);
            stack.pop();
        }

        for(int i = 0; i < s.length(); i++){
            if(!invalidIdx.contains(i)) res = res + s.charAt(i);
        }

        return res;

    }
}
