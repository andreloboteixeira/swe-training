import java.util.*;
public class Solution{
//    You are given two integer arrays nums1 and nums2,
//    sorted in non-decreasing order, and two integers m and n,
//    representing the number of elements in nums1 and nums2 respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//    The final sorted array should not be returned by the function,
//    but instead be stored inside the array nums1.
//    To accommodate this, nums1 has a length of m + n,
//    where the first m elements denote the elements that should be merged,
//    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//    Constraints:
//
//    nums1.length == m + n
//    nums2.length == n
//    0 <= m, n <= 200
//    1 <= m + n <= 200
//    -10^9 <= nums1[i], nums2[j] <= 10^9

    public static void main(String[] args){
        int[] ex1Input = new int[]{1,2,3,0,0,0};

        System.out.println("Ex1 expected:");
        System.out.println(Arrays.toString(new int[]{1,2,2,3,5,6}));

        Solution.merge(ex1Input, 3, new int[]{2, 5, 6}, 3);

        System.out.println("Ex1 my solution:");
        System.out.println(Arrays.toString(ex1Input));

        int[] ex2Input = new int[]{1};

        System.out.println("Ex2 expected:");
        System.out.println(Arrays.toString(new int[]{1}));

        Solution.merge(ex2Input, 1, new int[0], 0);

        System.out.println("Ex2 my solution:");
        System.out.println(Arrays.toString(ex2Input));

        int[] ex3Input = new int[]{0};

        System.out.println("Ex3 expected:");
        System.out.println(Arrays.toString(new int[]{1}));

        Solution.merge(ex3Input, 0, new int[]{1}, 1);

        System.out.println("Ex3 my solution:");
        System.out.println(Arrays.toString(ex3Input));

    }

    // t: O(m+n), s: O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;

        while(true){
            if(p2 < 0) break;

            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        return ;
    }
}
