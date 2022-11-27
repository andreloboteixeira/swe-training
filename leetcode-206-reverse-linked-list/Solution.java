import java.util.*;
public class Solution{
//    Given the head of a singly linked list,
//    reverse the list, and return the reversed list.

//    Constraints:
//    The number of nodes in the list is the range [0, 5000].
//    -5000 <= Node.val <= 5000

    public static void main(String[] args){
        ListNode ex1Head = new ListNode(1);
        ex1Head.next = new ListNode(2);
        ex1Head.next.next = new ListNode(3);
        ex1Head.next.next.next = new ListNode(4);
        ex1Head.next.next.next.next = new ListNode(5);

        System.out.println("Ex1 my solution");
        Solution.printList(Solution.reverseList(ex1Head));

        ListNode ex2Head = new ListNode(1);
        ex2Head.next = new ListNode(2);

        System.out.println("Ex2 my solution");
        Solution.printList(Solution.reverseList(ex2Head));

        ListNode ex3Head = null;

        System.out.println("Ex3 my solution");
        Solution.printList(Solution.reverseList(ex3Head));

    }

    // t: O(n), s: O(1)
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode prev = null, curr = head, next = head.next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;

    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
