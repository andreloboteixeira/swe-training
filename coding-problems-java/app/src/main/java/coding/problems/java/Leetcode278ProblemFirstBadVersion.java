package coding.problems.java;

import java.util.*;
public class Leetcode278ProblemFirstBadVersion{
//    Constraints:
//    1 <= bad <= n <= 2^31 - 1
    public static void main(String[] args){
        if(Leetcode278ProblemFirstBadVersion.firstBadVersion(5, new VersionControl(4)) == 4){
            System.out.println("Ex1 correct");
        }

        if(Leetcode278ProblemFirstBadVersion.firstBadVersion(1, new VersionControl(1)) == 1){
            System.out.println("Ex2 correct");
        }

    }

    // t: O(logn), s: O(1)
    public static int firstBadVersion(int n, VersionControl api) {
        int first = 0;

        int start = 1, end = n, mid = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(api.isBadVersion(mid)){
                first = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return first;
    }

}