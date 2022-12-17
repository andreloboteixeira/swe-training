import java.util.*;
public class Solution{
//    Write an efficient algorithm that searches
//    for a value target in an m x n integer matrix matrix.
//    This matrix has the following properties:
//
//    - Integers in each row are sorted from left to right.
//    - The first integer of each row is greater than the last integer of the previous row.
//
//    Constraints:
//
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 100
//    -10^4 <= matrix[i][j], target <= 10^4

    public static void main(String[] args){
        if(Solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3) == true){
            System.out.println("Ex1 correct");
        }

        if(Solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13) == false){
            System.out.println("Ex2 correct");
        }

    }

    // t: O(log(m*n)) binary search in the rowMajor array, s: constant
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length < 1 || matrix[0].length < 1) return false;

        int m = matrix.length, n = matrix[0].length;

        int start = 0, end = m*n - 1, mid = -1;
        while(start <= end){
            mid = start + (end - start)/2;

            if(target < matrix[mid/n][mid%n]){
                end = mid - 1;
            } else if(target > matrix[mid/n][mid%n]){
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
