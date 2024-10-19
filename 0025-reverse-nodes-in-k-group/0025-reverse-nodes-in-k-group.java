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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Initialize a temporary
        // node to traverse the list
        ListNode temp = head;
        
        // Initialize a pointer to track the
        // last node of the previous group
        ListNode prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            
            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(temp, k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {
               
                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node
            // after the Kth node
            ListNode nextNode = kThNode.next;
            
            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;
            
            // Reverse the nodes from
            // temp to the Kth node
            reverseLL(temp);
            
             // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }
            
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the
        // modified linked list
        return head;
    }

    static ListNode getKthNode(ListNode temp, int k) {
        // Decrement K as we already starts from k
        k = k - 1;
        
        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        
        return temp;
    }

    private static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

}