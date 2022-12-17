import java.util.*;
public class Solution{

//    In MATLAB, there is a handy function called reshape which can reshape
//    an m x n matrix into a new one with a different size r x c keeping its original data.
//
//    You are given an m x n matrix mat and two integers r and c
//    representing the number of rows and the number of columns of the wanted reshaped matrix.
//
//    The reshaped matrix should be filled with all the elements of the original matrix
//    in the same row-traversing order as they were.
//
//    If the reshape operation with given parameters is possible and legal,
//    output the new reshaped matrix; Otherwise, output the original matrix.

//    Constraints:
//
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 100
//    -1000 <= mat[i][j] <= 1000
//    1 <= r, c <= 300

    public static void main(String[] args){

        int[][] ex1Res = Solution.matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
        System.out.println("Ex1 my solution");
        for(int i = 0; i < ex1Res.length; i++){
            System.out.println(Arrays.toString(ex1Res[i]));
        }
        System.out.println("\n");

        int[][] ex2Res = Solution.matrixReshape(new int[][]{{1,2},{3,4}}, 2, 4);
        System.out.println("Ex2 my solution");
        for(int i = 0; i < ex2Res.length; i++){
            System.out.println(Arrays.toString(ex2Res[i]));
        }
        System.out.println("\n");

        int[][] ex3Res = Solution.matrixReshape(new int[][]{{1,2,3,4},{5,6,7,8}, {5,6,7,8}}, 2, 6);
        System.out.println("Ex3 my solution");
        for(int i = 0; i < ex3Res.length; i++){
            System.out.println(Arrays.toString(ex3Res[i]));
        }
        System.out.println("\n");

    }

    // t: O(m*n), s: O(m*n)
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if(m*n != r*c) return mat;

        int[][] reshaped = new int[r][c];

        int currR = 0, currC = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                reshaped[currR][currC] = mat[i][j];
                currC++;
                if(currC == c){
                    currC = 0;
                    currR++;
                }
            }
        }

        return reshaped;
    }
}
