public class Solution {
//    You are given an n x n 2D matrix representing an image,
//    rotate the image by 90 degrees (clockwise).
//
//    You have to rotate the image in-place,
//    which means you have to modify the input 2D matrix directly.
//
//    DO NOT allocate another 2D matrix and do the rotation.
//
//    Example 1:
//
//
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [[7,4,1],[8,5,2],[9,6,3]]
//    Example 2:
//
//
//    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//    Example 2:
//
//
//    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//    Constraints:
//
//    n == matrix.length == matrix[i].length
//    1 <= n <= 20
//    -1000 <= matrix[i][j] <= 1000

    public static void main(String[] args){
        int[][] ex1Input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ex1ExpectedRes = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        System.out.println("\nExpected result: ");
        for(int[] row: ex1ExpectedRes) {
            for(int i = 0; i < ex1ExpectedRes.length; i++) System.out.printf("%d ", row[i]);
            System.out.printf("\n");
        }

        Solution.rotate(ex1Input);

        System.out.println("\nMy solution:");
        for(int[] row: ex1Input) {
            for(int i = 0; i < ex1Input.length; i++) System.out.printf("%d ", row[i]);
            System.out.printf("\n");
        }
        System.out.printf("\n\n");

        int[][] ex2Input = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] ex2ExpectedRes = new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
        System.out.println("\nExpected result: ");
        for(int[] row: ex2ExpectedRes) {
            for(int i = 0; i < ex2ExpectedRes.length; i++) System.out.printf("%d ", row[i]);
            System.out.printf("\n");
        }

        Solution.rotate(ex2Input);

        System.out.println("\nMy solution:");
        for(int[] row: ex2Input) {
            for(int i = 0; i < ex2Input.length; i++) System.out.printf("%d ", row[i]);
            System.out.printf("\n");
        }


    }

    // t: O(n^2) + O(n^2) + O(n^2), s: O(1) + O(1)
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose by swaping elements [A^t]i,j = [A] j,i
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int aux = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = aux;
            }
        }

        // reverse rows with two pointers
        for(int row = 0; row < n; row++){
            int start = 0, end = n-1;
            while(start < end){
                int aux = matrix[row][end];
                matrix[row][end] = matrix[row][start];
                matrix[row][start] = aux;
                start++;
                end--;
            }
        }

    }

}