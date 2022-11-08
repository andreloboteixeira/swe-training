import java.util.*;
public class Solution{
//    Write an efficient algorithm that searches
//    for a value target in an m x n integer matrix matrix.
//    This matrix has the following properties:
//
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.
//
//    Example 1:
//
//    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//    Output: true
//
//    Example 2:
//
//    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//    Output: false
//
//    Constraints:
//
//    m == matrix.length
//    n == matrix[i].length
//    1 <= n, m <= 300
//    -109 <= matrix[i][j] <= 109
//    All the integers in each row are sorted in ascending order.
//    All the integers in each column are sorted in ascending order.
//    -109 <= target <= 109
    public static void main(String[] args){
        if(Solution.searchMatrix(new int[][]{
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        }, 5) == true) System.out.println("Ex1 correct");
        if(Solution.searchMatrix(new int[][]{
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        }, 20) == false) System.out.println("Ex2 correct");
        if(Solution.searchMatrix(new int[][]{
                {1,4},{2,5}
        }, 2) == true) System.out.println("Ex3 correct");
        if(Solution.searchMatrix(new int[][]{
                {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}
        }, 19) == true) System.out.println("Ex4 correct");

    }

    public static int bisearch(int[] arr, int target){
        int start = 0, end = arr.length - 1, middle = 0;
        while(start <= end){

            middle = start + (end - start)/2;

            if(arr[middle] == target){
                return middle;
            } else if(target < arr[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    // t: O(m.log n), s: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        for(int i = 0; i < m; i++){
            int found = Solution.bisearch(matrix[i], target);
            if(found != -1) return true;
        }
        return false;

    }

}
