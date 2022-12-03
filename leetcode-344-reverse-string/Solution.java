import java.util.*;
public class Solution{

//    Write a function that reverses a string. The input string is given as an array of characters s.
//
//    You must do this by modifying the input array in-place with O(1) extra memory.

//    Constraints:
//
//    1 <= s.length <= 10^5
//    s[i] is a printable ascii character.

    public static void main(String[] args){
        char[] ex1Input = new char[]{'h','e','l','l','o'};
        String ex1Expected = new String(new char[]{'o','l','l','e','h'});
        Solution.reverseString(ex1Input);
        if((new String(ex1Input)).equals(ex1Expected)) System.out.println("Ex1 correct");

        char[] ex2Input = new char[]{'H','a','n','n','a','h'};
        String ex2Expected = new String(new char[]{'h','a','n','n','a','H'});
        Solution.reverseString(ex2Input);
        if((new String(ex2Input)).equals(ex2Expected)) System.out.println("Ex2 correct");

    }

    // t: O(n/2) = O(n)
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        char aux = 'a';
        while(start < end){
            aux = s[start];
            s[start] = s[end];
            s[end] = aux;
            start++;
            end--;
        }
    }

}
