/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int lengthList1 = 0, lengthList2 = 0;
        ListNode mover = head1;
        while(mover!=null){
            lengthList1++;
            mover = mover.next;
        }
        mover = head2;

        while(mover!=null){
            lengthList2++;
            mover = mover.next;
        }

        if(lengthList1 > lengthList2) return collisionPoint(head1, head2, lengthList1 - lengthList2);
        else return collisionPoint(head2, head1, lengthList2 - lengthList1);
  
    }

    private static ListNode collisionPoint(ListNode largerListHead, ListNode smallerListHead, int difference){
        ListNode mover1 = largerListHead;
        for(int i=0; i<difference; i++){
            mover1 = mover1.next;
        }
        ListNode mover2 = smallerListHead;
        while(mover1!=mover2){
            mover1 = mover1.next;
            mover2 = mover2.next;
            if(mover1== null || mover2== null) return null;
        }

        return mover1;
    }
}