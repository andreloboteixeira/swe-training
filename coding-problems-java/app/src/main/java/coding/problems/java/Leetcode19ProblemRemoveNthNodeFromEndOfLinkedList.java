package coding.problems.java;

import java.util.*;

public class Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        ListNode ex1Input = new ListNode(1);
        ex1Input.next = new ListNode(2);
        ex1Input.next.next = new ListNode(3);
        ex1Input.next.next.next = new ListNode(4);
        ex1Input.next.next.next.next = new ListNode(5);

        System.out.println("\nMy solution: ");
        ListNode ex1Res = Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.removeNthFromEnd(ex1Input, 2);
        Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.printList(ex1Res);

        System.out.println("------ EXAMPLE 2");
        ListNode ex2Input = new ListNode(1);

        System.out.println("\nMy solution: ");
        ListNode ex2Res = Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.removeNthFromEnd(ex2Input, 1);
        Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.printList(ex2Res);

        System.out.println("------ EXAMPLE 3");
        ListNode ex3Input = new ListNode(1);
        ex3Input.next = new ListNode(2);

        System.out.println("\nMy solution: ");
        ListNode ex3Res = Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.removeNthFromEnd(ex3Input, 1);
        Leetcode19ProblemRemoveNthNodeFromEndOfLinkedList.printList(ex3Res);
    }

    // t: O(N), s: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;

        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        int posToUnlink = size - n;

        if(posToUnlink == 0) {
            head = head.next;
            return head;
        }

        ListNode prev = new ListNode(-1, head);
        curr = head;
        int i = 0;
        while(i < posToUnlink){
            prev = prev.next;
            curr = curr.next;
            i++;
        }

        prev.next = curr.next;

        return head;
    }

    private static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
