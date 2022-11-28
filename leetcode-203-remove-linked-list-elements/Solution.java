import java.util.*;
public class Solution{
//    Given the head of a linked list and an integer val,
//    remove all the nodes of the linked list that has Node.val == val, and return the new head.
//
//    Constraints:
//
//    The number of nodes in the list is in the range [0, 10^4].
//    1 <= Node.val <= 50
//    0 <= val <= 50

    public static void main(String[] args){
        ListNode ex1Head = new ListNode(1);
        ex1Head.next = new ListNode(2);
        ex1Head.next.next = new ListNode(6);
        ex1Head.next.next.next = new ListNode(3);
        ex1Head.next.next.next.next = new ListNode(4);
        ex1Head.next.next.next.next.next = new ListNode(5);
        ex1Head.next.next.next.next.next.next = new ListNode(6);
        System.out.println("Ex1 my solution");
        Solution.printList(Solution.removeElements(ex1Head, 6));

        ListNode ex2Head = null;
        System.out.println("Ex2 my solution");
        Solution.printList(Solution.removeElements(ex2Head, 1));

        ListNode ex3Head = new ListNode(7);
        ex3Head.next = new ListNode(7);
        ex3Head.next.next = new ListNode(7);
        ex3Head.next.next.next = new ListNode(7);
        System.out.println("Ex3 my solution");
        Solution.printList(Solution.removeElements(ex3Head, 7));

        ListNode ex4Head = new ListNode(1);
        ex4Head.next = new ListNode(2);
        ex4Head.next.next = new ListNode(2);
        ex4Head.next.next.next = new ListNode(1);
        System.out.println("Ex4 my solution");
        Solution.printList(Solution.removeElements(ex4Head, 2));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode prev = null, curr = head, next = null;

        while(curr != null){
            next = curr.next;

            if(curr.val != val){
                prev = curr;
                curr = next;
            } else {
                if(prev == null){
                    head = head.next;
                    curr = head;
                } else {
                    prev.next = next;
                    curr = next;
                }
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
