package coding.problems.java;

import java.util.*;

public class Leetcode733ProblemFloodFill{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        Leetcode733ProblemFloodFill.printImage(
                Leetcode733ProblemFloodFill.floodFill(
                        new int[][]{{1,1,1},{1,1,0},{1,0,1}},
                        1,
                        1,
                        2
                )

        );



        System.out.println("------ EXAMPLE 2");
        Leetcode733ProblemFloodFill.printImage(
                Leetcode733ProblemFloodFill.floodFill(
                        new int[][]{{0,0,0},{0,0,0},{0,0,0}},
                        0,
                        0,
                        0
                )
        );

    }

    // t: O(?), s: O(?)
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int prev = image[sr][sc];

        if(prev == color) return image;

        int area = Leetcode733ProblemFloodFill.floodFillRecurse(image, sr, sc, prev, color);

        return image;
    }


    private static int floodFillRecurse(int[][] image, int sr, int sc, int prev, int color){

        int area = 0;

        int rSize = image.length;
        int cSize = image[0].length;

        if(sr >= rSize || sr < 0 || sc >= cSize || sc < 0) return 0;
        int curr = image[sr][sc];

        if(curr != prev) return 0;

        area++;

        image[sr][sc] = color;

        if(sc + 1 < cSize) {
            area += Leetcode733ProblemFloodFill.floodFillRecurse(image, sr, sc + 1, prev, color);
        }


        if(sc - 1 >= 0){
            area+= Leetcode733ProblemFloodFill.floodFillRecurse(image, sr, sc - 1, prev, color);
        }


        if(sr - 1 >= 0){
            area+= Leetcode733ProblemFloodFill.floodFillRecurse(image, sr - 1, sc, prev, color);
        }

        if(sr + 1 < rSize){
            area+= Leetcode733ProblemFloodFill.floodFillRecurse(image, sr + 1, sc, prev, color);
        }

        return area;

    }

    private static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.println(image[i][j]);
            }
        }
    }
}
