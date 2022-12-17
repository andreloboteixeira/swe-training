package coding.problems.java;

import java.util.*;
public class Leetcode21ProblemMergeTwoSortedLists{
//    You are given the heads of two sorted linked lists list1 and list2.
//
//    Merge the two lists in a one sorted list.
//    The list should be made by splicing together the nodes of the first two lists.
//
//    Return the head of the merged linked list.

//    Constraints:
//
//    The number of nodes in both lists is in the range [0, 50].
//    -100 <= Node.val <= 100
//    Both list1 and list2 are sorted in non-decreasing order.

    public static void main(String[] args){
        ListNode ex1List1 = new ListNode(1);
        ex1List1.next = new ListNode(2);
        ex1List1.next.next = new ListNode(4);

        ListNode ex1List2 = new ListNode(1);
        ex1List2.next = new ListNode(3);
        ex1List2.next.next = new ListNode(4);

        System.out.println("Ex1 my solution");
        Leetcode21ProblemMergeTwoSortedLists.printList(Leetcode21ProblemMergeTwoSortedLists.mergeTwoLists(ex1List1, ex1List2));

        ListNode ex2List1 = null;
        ListNode ex2List2 = null;
        System.out.println("Ex2 my solution");
        Leetcode21ProblemMergeTwoSortedLists.printList(Leetcode21ProblemMergeTwoSortedLists.mergeTwoLists(ex2List1, ex2List2));

        ListNode ex3List1 = null;
        ListNode ex3List2 = new ListNode(0);
        System.out.println("Ex3 my solution");
        Leetcode21ProblemMergeTwoSortedLists.printList(Leetcode21ProblemMergeTwoSortedLists.mergeTwoLists(ex3List1, ex3List2));

    }

    // t: O(m+n), s: O(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE), curr = dummy;

        while(list1 != null || list2 != null){

            if(list1 == null){
                curr.next = list2;
                list2 = list2.next;
            } else if(list2 == null){
                curr.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
            }

            curr = curr.next;

        }

        return dummy.next;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
