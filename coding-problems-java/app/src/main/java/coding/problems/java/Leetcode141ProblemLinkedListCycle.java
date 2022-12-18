package coding.problems.java;

import java.util.*;
public class Leetcode141ProblemLinkedListCycle{
//    Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//    There is a cycle in a linked list if there is some node in the list that can be reached
//    again by continuously following the next pointer.
//    Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
//    Note that pos is not passed as a parameter.
//
//    Return true if there is a cycle in the linked list. Otherwise, return false.
//
//    Constraints:
//
//    The number of the nodes in the list is in the range [0, 10^4].
//    -10^5 <= Node.val <= 10^5
//    pos is -1 or a valid index in the linked-list.

    public static void main(String[] args){
        // 3,2,0,-4
        ListNode ex1Head = new ListNode(3);
        ex1Head.next = new ListNode(2);
        ex1Head.next.next = new ListNode(0);
        ex1Head.next.next = new ListNode(-4);
        ex1Head.next.next.next =  ex1Head.next; // pos 1 has cycle, linked to 2

        if(Leetcode141ProblemLinkedListCycle.hasCycle(ex1Head) == true){
            System.out.println("Ex1 correct");
        }

        // 1,2
        ListNode ex2Head = new ListNode(1);
        ex2Head.next = new ListNode(2);
        ex2Head.next.next = ex2Head; // pos 0 has cycle, linked to 1

        if(Leetcode141ProblemLinkedListCycle.hasCycle(ex2Head) == true){
            System.out.println("Ex2 correct");
        }

        // 1
        ListNode ex3Head = new ListNode(1); // no cycle

        if(Leetcode141ProblemLinkedListCycle.hasCycle(ex3Head) == false){
            System.out.println("Ex3 correct");
        }

        // null case
        ListNode ex4Head = null; // no cycle

        if(Leetcode141ProblemLinkedListCycle.hasCycle(ex4Head) == false){
            System.out.println("Ex4 correct");
        }
    }

    // t: floys's cycle detection is O(N-L) where N is number of nodes and L the loop length, s: O(1)
    public static boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;

    }
}
