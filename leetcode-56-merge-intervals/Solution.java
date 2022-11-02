import java.util.*;

public class Solution {
//    Given an array of intervals where intervals[i] = [starti, endi],
//    merge all overlapping intervals,
//    and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
//    Example 1:
//
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//    Example 2:
//
//    Input: intervals = [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//    Constraints:
//
//    1 <= intervals.length <= 10^4 intervals[i].length == 2
//    0 <= starti <= endi <= 10^4

    public static void main(String[] args){

        int[][] ex1Input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ex1ExpectedRes = new int[][]{{1,6},{8,10},{15,18}};
        int[][] ex1Res;
        System.out.println("\nExpected result: ");
        for(int[] interval: ex1ExpectedRes) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

        ex1Res = Solution.merge(ex1Input);

        System.out.println("\nMy solution:");
        for(int[] interval: ex1Res) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

        int[][] ex2Input = new int[][]{{1,4},{1,5}};
        int[][] ex2ExpectedRes = new int[][]{{1,5}};
        int[][] ex2Res;
        System.out.println("\nExpected result: ");
        for(int[] interval: ex2ExpectedRes) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

        ex2Res = Solution.merge(ex2Input);

        System.out.println("\nMy solution:");
        for(int[] interval: ex2Res) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

        int[][] ex3Input = new int[][]{{1,4},{1,4}};
        int[][] ex3ExpectedRes = new int[][]{{1,4}};
        int[][] ex3Res;
        System.out.println("\nExpected result: ");
        for(int[] interval: ex3ExpectedRes) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

        ex3Res = Solution.merge(ex3Input);

        System.out.println("\nMy solution:");
        for(int[] interval: ex3Res) {
            System.out.printf("[%d, %d]\n", interval[0], interval[1]);
        }

    }

    public static int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (first, second) -> first[0] - second[0]); // t: O(nlogn)

        List<int[]> resList = new ArrayList<int[]>(); // s: O(n)


        int prevStart = intervals[0][0], prevEnd = intervals[0][1];

        int[] curr = new int[2];
        for(int i = 1; i < intervals.length; i++){ // t: O(n) + O(n.logn), s: O(1)

            curr[0] = intervals[i][0];
            curr[1] = intervals[i][1];

            if(prevEnd < curr[0]){
                resList.add(new int[]{prevStart, prevEnd});
                prevStart = curr[0];
            }

            prevEnd = Integer.max(prevEnd, curr[1]);

        }

        resList.add(new int[]{prevStart, prevEnd}); // last remaining interval


        int[][] res = new int[resList.size()][2]; // just transforming solution as we don't know the res array size
        for(int k = 0; k < resList.size(); k++){
            res[k][0] = resList.get(k)[0];
            res[k][1] = resList.get(k)[1];
        }

        return res;
    }
}

//    int i = 0;
//        while(i < intervals.length){
//        List<Integer> interval = new ArrayList<Integer>();
//        interval.add(intervals[i][0]);
//        interval.add(intervals[i][1]);
//        resList.add(interval);
//        i++;
//        }