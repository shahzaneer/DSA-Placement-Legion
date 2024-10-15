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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //* */ if we move the fast pointer already by N places
        //* */ then we move slow and fast simultaneously 
        //* */ when fast will be at Len place then slow will be at len-n place...
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0; i<n;i++) fast = fast.next;

        if(fast == null){ 
            // the deletion Node is the head itself
        head = head.next;
        return head;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;

    }
}