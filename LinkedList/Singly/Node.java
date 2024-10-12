
import java.util.HashMap;
import java.util.Stack;



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

    // ! TC: O(2n) SC: O(n)
    static Node reverseLinkedListContent(Node head){
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

    // ! Reverse Iterative (Changing links) : TC: O(n) SC: O(1) 
    //? -> the approach is 3 pointers 
    static Node reverseLinkedListIterative(Node head){
        // 2 pointers outside one pointer inside
        Node mover = head;
        Node previous = null;

        while(mover!=null){
            Node newNext = mover.next;
            mover.next = previous;
            previous = mover;
            mover = newNext;
        }

        return previous;
    }

    // ! Reverse Recursive (changing links) : TC: O(n) SC: O() ( Memory Stack Used)
    static Node reverseLinkedListRecursive(Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverseLinkedListRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead; 
    }


    // ! Detection of a fucking loop in LinkedList
    // ! Brute: (using Hashing)
    // ! TC: O(n + 2 logn or 2(1)) SC: O(n)
    boolean hasLoopBrute(Node head){
        HashMap<Node, Integer> map = new HashMap<>();
        Node mover = head;
        while(mover!=null){
            if(map.containsKey(mover)) return true;
            map.put(mover, 1);
            mover = mover.next;
        }
        return false;
    }
    // ! Optimal: Hare and Tortoise Method
    // ! TC: O(n) SC: O(1)
    static boolean hasLoopOptimal(Node head){
        Node fast = head;
        Node slow = head;
        while( fast!=null && fast.next!=null){
            slow = slow.next;
            if(fast.next!=null)
                fast =  fast.next.next;
            if(fast == slow) return true; //? why so? the reason is the net reduction of (d-1)
        }
        return false;
    }



    // ! Length of a fucking loop in LinkedList
    // ! Brute: (using Hashing)
    // ! TC: O(n + 2 log n or 2 (1)) SC: O(n)
    static int lengthOfLoopBrute(Node head){
        HashMap<Node, Integer> map = new HashMap<>();
        int counter = 1;
        Node mover = head;
        while(mover!=null){
            if(map.containsKey(mover)){
                return (counter - map.get(mover));
            }
            else{
                map.put(mover, counter);
                counter++;
            }
            mover = mover.next;
        }
        return 0;

    }

    // ! Optimal: Hare and Tortoise Method
    // ! TC: O(n + some part of n) SC: O(1)
    static int lengthOfLoop(Node head){
        Node fast = head;
        Node slow = fast;
        while(fast!=null && fast.next!=null){
            slow  = slow.next;
            fast = fast.next;

            if(fast == slow) return lengthLL(slow, fast);
        }

        return 0;
    }
    
    private static int lengthLL(Node slow, Node fast) {
        int counter = 1;
        fast = fast.next;
        while(fast!=slow){
            fast = fast.next;
            counter++;
        }
        return counter;
    }
}
