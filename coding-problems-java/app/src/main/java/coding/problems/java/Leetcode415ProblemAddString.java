package coding.problems.java;

public class Leetcode415ProblemAddString{
//    Given two non-negative integers, num1 and num2 represented as string,
//    return the sum of num1 and num2 as a string.
//
//    You must solve the problem without using any built-in library
//    for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
//
//    Example 1:
//
//    Input: num1 = "11", num2 = "123"
//    Output: "134"
//
//    Example 2:
//
//    Input: num1 = "456", num2 = "77"
//    Output: "533"
//
//    Example 3:
//
//    Input: num1 = "0", num2 = "0"
//    Output: "0"
//
//
//    Constraints:
//
//    1 <= num1.length, num2.length <= 10^4
//    num1 and num2 consist of only digits.
//    num1 and num2 don't have any leading zeros except for the zero itself.
    public static void main(String[] args){
        System.out.println("\n\nEx1");
        System.out.println("Expected");
        System.out.println("134");
        System.out.println("My solution");
        System.out.println(Leetcode415ProblemAddString.addStrings("11", "123"));

        System.out.println("\n\nEx2");
        System.out.println("Expected");
        System.out.println("533");
        System.out.println("My solution");
        System.out.println(Leetcode415ProblemAddString.addStrings("456", "77"));

        System.out.println("\n\nEx3");
        System.out.println("Expected");
        System.out.println("0");
        System.out.println("My solution");
        System.out.println(Leetcode415ProblemAddString.addStrings("0", "0"));

        System.out.println("\n\nEx4");
        System.out.println("Expected");
        System.out.println("1111111110");
        System.out.println("My solution");
        System.out.println(Leetcode415ProblemAddString.addStrings("123456789", "987654321"));

    }

    public static String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();

        int c1 = 0;
        int c2 = 0;
        int sum = 0;
        int currDigit = 0;
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){

            c1 = i >=0 ? num1.charAt(i) - '0' : 0;
            c2 = j >=0 ? num2.charAt(j) - '0' : 0;

            sum = c1 + c2 + carry;
            carry = sum/10;
            currDigit = sum%10;

            res.append(currDigit);
        }

        return res.reverse().toString();
    }

}