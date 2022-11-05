public class Solution{
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
        System.out.println(Solution.addStrings("11", "123"));

        System.out.println("\n\nEx2");
        System.out.println("Expected");
        System.out.println("533");
        System.out.println("My solution");
        System.out.println(Solution.addStrings("456", "77"));

        System.out.println("\n\nEx3");
        System.out.println("Expected");
        System.out.println("0");
        System.out.println("My solution");
        System.out.println(Solution.addStrings("0", "0"));

        System.out.println("\n\nEx4");
        System.out.println("Expected");
        System.out.println("1111111110");
        System.out.println("My solution");
        System.out.println(Solution.addStrings("123456789", "987654321"));

    }

    public static String addStrings(String num1, String num2) {

        int first = 0;
        int second = 0;
        int sum = 0;
        String res = "";

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int carry = 0;
        int digit = 0;
        for(int i = 0; i < num1.length() || i < num2.length(); i++){
            int c1 = 0;
            int c2 = 0;

            if(i < num1.length()){
                c1 = num1.charAt(i) - '0';
            }
            if(i < num2.length()){
                c2 = num2.charAt(i) - '0';
            }
            sum = c1 + c2 + carry;
            digit = sum%10;
            carry = sum/10;

            res = digit + res;
        }
        if(carry != 0) res = carry + res;

        return res;
    }

}