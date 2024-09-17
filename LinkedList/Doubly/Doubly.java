public class Doubly {
      public static void main(String[] args) {
        Node head = Node.makeDoublyLinkedList(new int [] {1,2,3,4,5,6,7});
        Node mover = head;
        
        while(mover!=null){
            System.out.println(mover.data);
            mover = mover.next;
        }
      }
}
