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
    public boolean isPalindrome(ListNode head) {
     if(head == null || head.next == null) return true;
        // O(n/2)
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // O (n/2)
        // slow has the first middle if even and middle if odd
        ListNode newHead = reverseLinkedListIterative(slow.next);
        // O(n/2)
        ListNode first = head, second = newHead;
        while(second!=null){
            if(first.val!= second.val) {
                reverseLinkedListIterative(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedListIterative(newHead);
        return true;   
    }

    static ListNode reverseLinkedListIterative(ListNode head){
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