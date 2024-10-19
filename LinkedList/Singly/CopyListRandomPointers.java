
import java.util.HashMap;

public class CopyListRandomPointers {
    public static void main(String[] args) {
        
    }
//! Copy a list with same next and random pointers
//! TC: O(2n) SC: O(n)
   static NodeR copyList(NodeR head){
    HashMap<NodeR,NodeR> map = new HashMap<>();
   

    NodeR mover = head;
    while(mover!=null){
        NodeR newNode = new NodeR(mover.data);
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

class NodeR{
    NodeR random;
    NodeR next;
    int data;

    NodeR(int data){
        this.data = data;
    }
}
