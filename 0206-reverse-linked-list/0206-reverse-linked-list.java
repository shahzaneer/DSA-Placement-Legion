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
    public ListNode reverseList(ListNode head) {
        // 2 pointers outside one pointer inside
        ListNode mover = head;
        ListNode previous = null;

        while(mover!=null){
            ListNode newNext = mover.next;
            mover.next = previous;
            previous = mover;
            mover = newNext;
        }

        return previous;
    }
}