

public class Node {
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }

    static Node makeSinglyLinkedList(int [] array){
        if (array.length == 0) {
            return null; 
        }
        Node head = new Node(array[0]);
        Node current = head;
        for(int i=1; i<array.length; i++){
            Node temp = new Node(array[i]);
             current.next = temp;
             current = temp;
        }
        return head;
    }
}
