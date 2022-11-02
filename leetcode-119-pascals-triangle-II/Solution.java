import java.util.*;

public class Solution {
//    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//    Example 1:
//
//    Input: rowIndex = 3
//    Output: [1,3,3,1]
//
//    Example 2:
//
//    Input: rowIndex = 0
//    Output: [1]
//
//    Example 3:
//
//    Input: rowIndex = 1
//    Output: [1,1]

    public static void main(String[] args){
        int ex1Input = 3;
        List<Integer> ex1ExpectedRes = Arrays.asList(1,3,3,1);
        List<Integer> ex1Res;
        System.out.println("\nExpected result: ");
        System.out.println(ex1ExpectedRes.toString());

        ex1Res = Solution.getRow(ex1Input);

        System.out.println("\nMy solution:");
        System.out.println(ex1Res.toString());

        int ex2Input = 0;
        List<Integer> ex2ExpectedRes = Arrays.asList(1);
        List<Integer> ex2Res;
        System.out.println("\nExpected result: ");
        System.out.println(ex2ExpectedRes.toString());

        ex2Res = Solution.getRow(ex2Input);

        System.out.println("\nMy solution:");
        System.out.println(ex2Res.toString());

        int ex3Input = 1;
        List<Integer> ex3ExpectedRes = Arrays.asList(1,1);
        List<Integer> ex3Res;
        System.out.println("\nExpected result: ");
        System.out.println(ex3ExpectedRes.toString());

        ex3Res = Solution.getRow(ex3Input);

        System.out.println("\nMy solution:");
        System.out.println(ex3Res.toString());

        int ex4Input = 10;
        List<Integer> ex4ExpectedRes = Arrays.asList(1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1);
        List<Integer> ex4Res;
        System.out.println("\nExpected result: ");
        System.out.println(ex4ExpectedRes.toString());

        ex4Res = Solution.getRow(ex4Input);

        System.out.println("\nMy solution:");
        System.out.println(ex4Res.toString());

    }

    // t: O(n^2), s: O(n) + O(n)
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return Arrays.asList(1);

        List<Integer> aux = new ArrayList<Integer>(); // base case
        aux.add(1);
        aux.add(1);

        List<Integer> res = aux;

        for(int i = 1; i < rowIndex; i++){
            res = new ArrayList<Integer>();
            res.add(1);

            for(int j = 0; j < i; j++){
                res.add(aux.get(j) + aux.get(j+1));
            }

            res.add(1);
            aux = res;
        }

        return res;
    }
}