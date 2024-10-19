import java.util.ArrayList;
import java.util.Comparator;

public class FlatListNode{
     int data;
     FlatListNode next;
     FlatListNode child;
     
     FlatListNode(int data){
          this.data = data;
     }

     // ! Flatten a list in sorted order
     // ! TC: O(2(n*m) + n*m log n*m) SC: O(2(n*m))
     Node flatList(FlatListNode head){
          ArrayList<Integer> list = new ArrayList<>();
          FlatListNode listMover = head;
          while(listMover!=null){
               list.add(listMover.data);
               FlatListNode childMover = listMover.child;
               while(childMover!=null){
                    list.add(childMover.data);
                    childMover = childMover.child;
               }
               listMover = listMover.next;
          }
          
          list.sort(Comparator.naturalOrder());
          Node dummy = new Node(-1);
          Node current = dummy;

          for(Integer element: list){
               Node newNode = new Node(element);
               current.next = newNode;
               current = current.next;
          }

          return dummy.next;

          
     }
     
}


