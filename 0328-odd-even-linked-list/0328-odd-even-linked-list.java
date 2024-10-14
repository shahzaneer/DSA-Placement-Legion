/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddMover = head;
        ListNode evenMover = head.next;
        ListNode evenHead = head.next;
        while (evenMover!=null && evenMover.next!=null) { 
            oddMover.next = oddMover.next.next;
            evenMover.next = evenMover.next.next;

            oddMover = oddMover.next;
            evenMover = evenMover.next;
        }
        oddMover.next = evenHead;
        return head;
    }
}