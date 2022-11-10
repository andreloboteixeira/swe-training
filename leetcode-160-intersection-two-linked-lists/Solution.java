import java.util.*;

public class Solution {

    public static void main(String[] args){

        //Ex1
        ListNode intersectionEx1 = new ListNode(8);
        intersectionEx1.next = new ListNode(4);
        intersectionEx1.next.next = new ListNode(5);

        ListNode listAEx1 = new ListNode(4);
        listAEx1.next = new ListNode(1);
        listAEx1.next.next = intersectionEx1;

        ListNode listBEx1 = new ListNode(5);
        listBEx1.next = new ListNode(6);
        listBEx1.next.next = new ListNode(1);
        listBEx1.next.next.next = intersectionEx1;

        ListNode res1 = Solution.getIntersectionNode(listAEx1, listBEx1);
        System.out.println("My answer, intersection node value: ");
        System.out.println(res1 != null ? res1.val : null);

        //Ex3
        ListNode listAEx3 = new ListNode(2);
        listAEx3.next = new ListNode(6);
        listAEx3.next.next = new ListNode(4);

        ListNode listBEx3 = new ListNode(1);
        listBEx3.next = new ListNode(5);

        ListNode res3 = Solution.getIntersectionNode(listAEx3, listBEx3);
        System.out.println("My answer, intersection node value: ");
        System.out.println(res3 != null ? res3.val : null);

    }
    // t: O(m + n), s: O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){

            if(p1 == null){
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if(p2 == null){
                p2 = headA;
            } else {
                p2 = p2.next;
            }

        }
        return p1;
    }
}
