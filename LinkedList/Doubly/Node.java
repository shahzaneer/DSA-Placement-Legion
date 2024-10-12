import java.util.Stack;

public class Node {
    int data;
    Node next;
    Node previous;

    Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    Node(int data, Node next, Node previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    static Node makeDoublyLinkedList(int [] array){
        if(array.length == 0) return null;

            Node head = new Node(array[0]);
            Node current = head;
            current.previous = null;

            for(int i=1; i<array.length; i++){
                Node temp = new Node(array[i]);
                current.next = temp;
                temp.previous =  current;
                temp.next = null;
                current = temp;
            }

            return head;
    }

    static Node insertAtTail(Node head,int value){
        Node newNode = new Node(value, null, null);
        if(head == null) return newNode;

        Node mover = head;
        while(mover.next!=null){
            mover = mover.next;
        }
        mover.next = newNode;
        newNode.previous = mover;

        return head;
    }

    static Node deleteFromLast(Node head){
        if(head.next == null){
            head = null;
            return head;
        }

        Node mover = head;
        Node lastNode = null;
        while(mover.next.next!=null){
            mover = mover.next;
            lastNode = mover.next;
        }

        mover.next = null;
        if(lastNode!=null)
            lastNode.previous = null;

        return head;
    }

    // ! TC: O(2n) SC: O(n)
    static Node reverseDoublyLinkedListContent(Node head){
        Stack<Integer> stack = new Stack<>();
        Node mover = head;
        while(mover!=null){
            stack.push(mover.data);
            mover = mover.next;
        }
        mover = head;
        while(mover!=null){
            mover.data = stack.pop();
            mover = mover.next;
        }
        return head;
    }

    // ! TC: O(n) SC: O(1)
    // just swap the links
    // make 
    // previous into next
    // next into previous
    static Node reverseDoublyLinkedList(Node head) {
        Node mover = head;
        Node newHead = null;
    
        while (mover != null) {
            // Swap the next and previous pointers
            Node temp = mover.next;
            mover.next = mover.previous;
            mover.previous = temp;
    
            // Update new head to the current node (which will become the last node)
            newHead = mover;
    
            //! Move to the next node, which is now the previous node due to swapping
            mover = mover.previous;
        }
    
        return newHead; // The new head is the last node of the original list
    }
    
    
}

