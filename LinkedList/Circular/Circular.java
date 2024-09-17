public class Circular {
   public static void main(String[] args) {
     Node head = Node.makeCircularLinkedList(new int [] {1,2,3,4,5,5,6,7});
     Node mover = head;
     do{
        System.out.println(mover.data);
        mover = mover.next;
     }while(mover!=head);
   }

}
