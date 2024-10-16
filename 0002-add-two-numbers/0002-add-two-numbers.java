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
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        ListNode moving1 = head1;
        ListNode moving2 = head2;

        int carry = 0;

        while (moving1!=null || moving2!=null ) { 
        int sum = carry;
        if(moving1!=null) sum+=moving1.val;
        if(moving2!=null) sum+=moving2.val;
        ListNode newNode = new ListNode((sum % 10));
        carry = sum/10;
        current.next = newNode;
        current = newNode;

        if(moving1!=null) moving1 = moving1.next;
        if(moving2!=null) moving2 = moving2.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode; 
        }

        return dummyNode.next;
    }
}