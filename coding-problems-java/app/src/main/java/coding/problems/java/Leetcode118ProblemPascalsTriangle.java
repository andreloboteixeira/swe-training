package coding.problems.java;

import java.util.*;
public class Leetcode118ProblemPascalsTriangle{
//    Given an integer numRows,
//    return the first numRows of Pascal's triangle.
//
//    Constraints:
//    1 <= numRows <= 30

    public static void main(String[] args){

        System.out.println("Ex1 my solution");
        for(List<Integer> list: Leetcode118ProblemPascalsTriangle.generate(5)){
            for(Integer el: list) System.out.printf("%d, ", el);
            System.out.println("");
        }

        System.out.println("Ex2 my solution");
        for(List<Integer> list: Leetcode118ProblemPascalsTriangle.generate(1)){
            for(Integer el: list) System.out.printf("%d, ", el);
            System.out.println("");
        }


    }

    // t: O(n), s: O(n)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> baseCase = new ArrayList<Integer>();
        baseCase.add(1);
        res.add(baseCase);

        for(int i = 2; i <= numRows; i++){

            List<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            for(int j = 0; j < res.get(i - 1 - 1).size() - 1; j++){
                int newEl = res.get(i - 1 - 1).get(j) + res.get(i - 1 - 1).get(j+1);
                newRow.add(newEl);
            }
            newRow.add(1);

            res.add(newRow);
        }

        return res;
    }
}
