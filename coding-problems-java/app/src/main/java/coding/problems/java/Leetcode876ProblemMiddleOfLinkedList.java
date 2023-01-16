package coding.problems.java;

import java.util.*;

public class Leetcode876ProblemMiddleOfLinkedList{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        ListNode ex1Input = new ListNode(1);
        ex1Input.next = new ListNode(2);
        ex1Input.next.next = new ListNode(3);
        ex1Input.next.next.next = new ListNode(4);
        ex1Input.next.next.next.next = new ListNode(5);

        System.out.println("\nMy solution: ");
        System.out.println(Leetcode876ProblemMiddleOfLinkedList.middleNode(ex1Input).val);

        System.out.println("------ EXAMPLE 2");
        ListNode ex2Input = new ListNode(1);
        ex2Input.next = new ListNode(2);
        ex2Input.next.next = new ListNode(3);
        ex2Input.next.next.next = new ListNode(4);
        ex2Input.next.next.next.next = new ListNode(5);
        ex2Input.next.next.next.next.next = new ListNode(6);

        System.out.println("\nMy solution: ");
        System.out.println(Leetcode876ProblemMiddleOfLinkedList.middleNode(ex2Input).val);
    }

    // t: O(N) + O(N/2) = O(N), s: O(1)
    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        int i = 0;
        curr = head;
        while(i < size/2){
            curr = curr.next;
            i++;
        }

        return curr;
    }

}
