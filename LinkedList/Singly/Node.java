

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

    static void LinkedListTraversal(Node head){
        Node mover = head;
        while(mover!= null){
            System.out.println(mover.data);
            mover = mover.next;  
        }

    }
    static Node insertNode(Node head,int position, int data){
        Node newNode = new Node(data);
        if(position == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        else{
            Node current = head;
            Node previous = null;
            int counter = 1;
            while(counter!=position && current.next!=null){
                counter++;
                previous = current;
                current = current.next;
            }
            if(current.next == null){
                current.next = newNode;
                return head;
            }
            previous.next = newNode;
            newNode.next = current;
            return head;
        }

    }
    // LC - 69
    static void delete(Node node){
        // Copy the value of the next node to the current node
        node.data = node.next.data;
        
        // Point the current node to the next of the next node (bypass the next node)
        node.next = node.next.next;
    }
    static Node deleteNode(Node head, int data){
        if(head.data == data){
            Node temp = head;
            head = head.next;
            temp = null;
            return head;
        }
        Node mover = head;
        Node previous = null;
        while(mover!=null || mover.data != data){
            previous = mover;
            mover = mover.next;
        }

        Node temp = mover;
        if(mover.next == null){
            previous.next = null;
            mover = null;
            return head;
        }
        previous.next = mover.next;
        mover = null;
        return head;
    }
    // LC - 70 
    static Node middleNode(Node head){
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    static int lengthOfLL(Node head){
        int counter = 0;
        Node current = head;
        while(current!=null){
            counter++;
            current = current.next;
        }
        return counter;
    }

    static boolean searchInLL(Node head, int key){
        Node current = head;
        while(current!=null){
            if(current.data == key) return  true;
            current = current.next;
        }
        return false;
    }

}
