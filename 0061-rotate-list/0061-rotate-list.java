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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next!=null){
            length++;
            tail = tail.next;
        }
         
        if(k % length == 0) return head;
        k = k % length;
        ListNode newLastNode = findNewLastNode(head, (length - k));
        tail.next = head;
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    static ListNode findNewLastNode(ListNode head, int count){
        ListNode mover = head;
        while(count!=1){
            count--;
            mover = mover.next;
        }

        return mover;
    }

}