package coding.problems.java;

import java.util.*;
public class Leetcode83ProblemRemoveDuplicatesFromSortedList{

//    Given the head of a sorted linked list,
//    delete all duplicates such that each element appears only once.
//    Return the linked list sorted as well.
//
//    Constraints:
//
//    The number of nodes in the list is in the range [0, 300].
//    -100 <= Node.val <= 100
//    The list is guaranteed to be sorted in ascending order.

    public static void main(String[] args){
        ListNode ex1Head = new ListNode(1);
        ex1Head.next = new ListNode(1);
        ex1Head.next.next = new ListNode(2);

        System.out.println("ex1 my solution");
        Leetcode83ProblemRemoveDuplicatesFromSortedList.printList(Leetcode83ProblemRemoveDuplicatesFromSortedList.deleteDuplicates(ex1Head));


        ListNode ex2Head = new ListNode(1);
        ex2Head.next = new ListNode(1);
        ex2Head.next.next = new ListNode(2);
        ex2Head.next.next.next = new ListNode(3);
        ex2Head.next.next.next.next = new ListNode(3);

        System.out.println("ex2 my solution");
        Leetcode83ProblemRemoveDuplicatesFromSortedList.printList(Leetcode83ProblemRemoveDuplicatesFromSortedList.deleteDuplicates(ex2Head));

    }

    // t: O(n), s: O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode prev = null, curr = head;
        while(curr != null){
            if(prev != null && prev.val == curr.val){
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;

    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
