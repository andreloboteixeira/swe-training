import java.util.*;

public class Solution {
//		Given a positive integer n,
//		generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//		Example 1:
//
//		Input: n = 3
//		Output: [[1,2,3],[8,9,4],[7,6,5]]
//
//		Example 2:
//
//		Input: n = 1
//		Output: [[1]]
//
//
//		Constraints:
//		1 <= n <= 20
	public static void main(String[] args){
		for(int n = 1; n < 8; n++){

			System.out.printf("For n = %d\n", n);
			System.out.println("My sol:");
			int [][] res = Solution.generateMatrix(n);
			for(int i = 0; i < res.length; i++){
				System.out.println(Arrays.toString(res[i]));
			}
			System.out.println("\n");

		}

	}

	// t: O(n^2), s: O(1)
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];

		int mid = n/2, val = 1;

		for(int first = 0; first < mid; first++){
			int last = n - first -1;

			for(int k = first; k < last; k++){
				res[first][k] = val++;
			}

			for(int k = first; k < last; k++){
				res[k][last] = val++;
			}

			for(int k = last; k > first; k--){
				res[last][k] = val++;
			}

			for(int k = last; k > first; k--){
				res[k][first] = val++;
			}

		}

		if(n%2 == 1) res[mid][mid] = val;

		return res;
	}
}
