import java.util.*;
public class Solution{
//    Given two integer arrays nums1 and nums2,
//    return an array of their intersection.
//    Each element in the result must appear as many times
//    as it shows in both arrays and you may return the result in any order
//
//    Constraints:
//
//    1 <= nums1.length, nums2.length <= 1000
//    0 <= nums1[i], nums2[i] <= 1000
    public static void main(String[] args){
        System.out.println("Ex1 expected");
        System.out.println(Arrays.toString(new int[]{2,2}));
        int[] ex1Res = Solution.intersect(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println("Ex1 my solution");
        System.out.println(Arrays.toString(ex1Res));

        System.out.println("Ex2 expected");
        System.out.println(Arrays.toString(new int[]{4,9}));
        int[] ex2Res = Solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println("Ex2 my solution");
        System.out.println(Arrays.toString(ex2Res));

    }

    // t: O(max(m, n)), s: O(max(m,n))
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        List<Integer> res = new ArrayList<Integer>();

        Map<Integer, Integer> freq1 = new HashMap<Integer, Integer>();

        for(int p1 = 0; p1 < nums1.length; p1++){
            if(freq1.containsKey(nums1[p1])){
                freq1.put(nums1[p1], freq1.get(nums1[p1]) + 1);
            } else{
                freq1.put(nums1[p1], 1);
            }
        }

        for(int p2 = 0; p2 < nums2.length; p2++){
            if(freq1.containsKey(nums2[p2]) && freq1.get(nums2[p2]) > 0){
                    res.add(nums2[p2]);
                    freq1.put(nums2[p2], freq1.get(nums2[p2]) - 1);
            }
        }

        return Solution.toArray(res);
    }

    public static int[] toArray(List<Integer> list){
        int[] arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }
}
