/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    HashMap<Node,Node> map = new HashMap<>();
   

    Node mover = head;
    while(mover!=null){
        Node newNode = new Node(mover.val);
        map.put(mover, newNode);
        mover = mover.next;
    }

    mover = head;
    while(mover!=null){
        map.get(mover).next = map.get(mover.next);
        map.get(mover).random = map.get(mover.random); 
        mover = mover.next;
    }

    return map.get(head);
    }
}