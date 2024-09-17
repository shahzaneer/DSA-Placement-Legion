

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


    
}

