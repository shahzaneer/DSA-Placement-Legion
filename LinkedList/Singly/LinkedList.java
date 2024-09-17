public class LinkedList {
    public static void main(String[] args) {
        Node head = Node.makeSinglyLinkedList(new int []{1,2,3,4,5,6,7});
        Node mover = head;
        while(mover!= null){
            System.out.println(mover.data);
            mover = mover.next;  
        }
    }
}
