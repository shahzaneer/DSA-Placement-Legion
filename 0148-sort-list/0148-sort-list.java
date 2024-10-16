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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode middleNode = getMiddleNode(head);

        ListNode leftHead = head;
        ListNode rightHead = middleNode.next;
        middleNode.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        head = merge2LL(leftHead, rightHead);
        return head;
    }

    private static ListNode merge2LL(ListNode leftHead, ListNode rightHead){
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        
        while(leftHead!=null && rightHead!=null){
            if(leftHead.val <= rightHead.val){
                current.next = leftHead;
                leftHead = leftHead.next;
                
            }else{
                current.next = rightHead;
                rightHead = rightHead.next;
            }
            current = current.next;
        }

        if(leftHead!=null){
            current.next = leftHead;
        }
        else{
            current.next = rightHead;
        }

        return dummyNode.next;

    }

    private static ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}