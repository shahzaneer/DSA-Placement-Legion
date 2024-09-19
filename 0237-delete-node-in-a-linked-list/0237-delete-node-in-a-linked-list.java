/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // head node nhi dya hua yani traverse nhi krna , krna hai yahan jugaar!
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        
        // Point the current node to the next of the next node (bypass the next node)
        node.next = node.next.next;
    }
}