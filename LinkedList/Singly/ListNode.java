import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ListNode {
    int data;
    ListNode next;

    ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }

    ListNode(int data){
        this.data = data;
        this.next = null;
    }

    static ListNode makeSinglyLinkedList(int [] array){
        if (array.length == 0) {
            return null; 
        }
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for(int i=1; i<array.length; i++){
            ListNode temp = new ListNode(array[i]);
             current.next = temp;
             current = temp;
        }
        return head;
    }

    static void LinkedListTraversal(ListNode head){
        ListNode mover = head;
        while(mover!= null){
            System.out.println(mover.data);
            mover = mover.next;  
        }

    }

    // ! Sort a LL
    // ! Brute: using extra space
    // ! TC: O(n + nlogn + n) SC: O(n)
    static ListNode sortBrute(ListNode head){
        if(head == null || head.next == null) return head;
        ArrayList<Integer> temp = new ArrayList<>();
        ListNode mover = head;
        while(mover!=null){
            temp.add(mover.data);
            mover = mover.next;
        }
        temp.sort(Comparator.naturalOrder());
        mover = head;
        int index = 0;
        while(mover!=null){
            mover.data = temp.get(index);
            index++;
            mover = mover.next;
        }

        return head;

    }
    // !Optimal: applying Merge sort
    // ! TC : O(nlogn + n/2) SC: O(1)
    static ListNode mergeSortLL(ListNode head){
        return mergeSort(head);
    }

    // TC: O(logn)
    private static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode middleNode = getMiddleNode(head);
        ListNode leftHead = head;
        ListNode rightHead = middleNode.next;
        middleNode.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        head = merge2LL(leftHead, rightHead);
        return head;
    }

    // TC: O(n)
    private static ListNode merge2LL(ListNode leftHead, ListNode rightHead){
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        
        while(leftHead!=null && rightHead!=null){
            if(leftHead.data <= rightHead.data){
                current.next = leftHead;
                leftHead = leftHead.next;
                
            }else{
                current.next = rightHead;
                rightHead = rightHead.next;
            }
            current = current.next;
        }

        if(leftHead!=null){
            current.next = leftHead;
        }
        else{
            current.next = rightHead;
        }

        return dummyNode.next;

    }

    // TC: O(n/2)
    private static ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ! Sort the LinkedList of 0s 1s and 2s
    //! Brute: TC: O(2n) SC: O(1)
    static ListNode sortB(ListNode head){
        if(head == null || head.next == null) return head;
        int counterZeros = 0, counterOnes = 0, countertwos = 0;
        ListNode mover = head;
        while(mover!=null){
            switch (mover.data) {
                case 0 -> counterZeros++;
                case 1 -> counterOnes++;
                case 2 -> countertwos++;
                
            }
            mover = mover.next;
        }

        mover = head;
        while(counterZeros!=0){
            mover.data = 0;
            counterZeros--;
            mover = mover.next;
        }
        while(counterOnes!=0){
            mover.data = 1;
            counterOnes--;
            mover = mover.next;
        }
        while(countertwos!=0){
            mover.data = 2;
            countertwos--;
            mover = mover.next;
        }

        return head;
    }
    // ! Optimal: TC:O(n) SC: O(1)
    static ListNode sortO(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode zerosHead = new ListNode(-1);
        ListNode onesHead = new ListNode(-1);
        ListNode twosHead = new ListNode(-1);

        ListNode zeros = zerosHead;
        ListNode ones = onesHead;
        ListNode twos = twosHead;

        ListNode mover = head;
        while(mover!=null){
            switch (mover.data) {
                case 0 -> {
                    zeros.next = mover;
                    zeros = zeros.next;
                }
                case 1 -> {
                    ones.next = mover;
                    ones = ones.next;
                }
                case 2 -> {
                    twos.next = mover;
                    twos = twos.next;
                }
            }

            mover = mover.next;
        }

        zeros.next = (onesHead.next!= null)? onesHead.next: twosHead.next;
        ones.next = twosHead.next;
        twos.next = null;

        return head;
    }


    // ! Intersection Point of two LinkedLists
    // ! Brute: TC: O(h1 + h2) SC: O(h1)
    static ListNode intersectionNodeBrute(ListNode head1, ListNode head2){
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode mover = head1;
        while(mover!=null){
            map.put(mover, 1);
            mover = mover.next;
        }
        mover = head2;
        while(mover!=null){
            if(map.containsKey(mover)) return mover;
         mover = mover.next;   
        }
        return null;
    }
    // ! Optimal: TC: O(h1 + h2 + max(h1,h2) ) SC: O(1)
    static ListNode intersectionNodeOptimal(ListNode head1, ListNode head2){
        int lengthList1 = 0, lengthList2 = 0;
        ListNode mover = head1;
        while(mover!=null){
            lengthList1++;
            mover = mover.next;
        }
        mover = head2;

        while(mover!=null){
            lengthList2++;
            mover = mover.next;
        }

        if(lengthList1 > lengthList2) return collisionPoint(head1, head2, lengthList1 - lengthList2);
        else return collisionPoint(head2, head1, lengthList2 - lengthList1);
    }

    private static ListNode collisionPoint(ListNode largerListHead, ListNode smallerListHead, int difference){
        ListNode mover1 = largerListHead;
        for(int i=0; i<difference; i++){
            mover1 = mover1.next;
        }
        ListNode mover2 = smallerListHead;
        while(mover1!=mover2){
            mover1 = mover1.next;
            mover2 = mover2.next;
            if(mover1== null || mover2== null) return null;
        }

        return mover1;
    }

    // ! Add two Numbers
    // ! Optimal: TC: O(max(h1,h2)) SC: O(1)
    static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        ListNode moving1 = head1;
        ListNode moving2 = head2;

        int carry = 0;

        while (moving1!=null || moving2!=null ) { 
        int sum = carry;
        if(moving1!=null) sum+=moving1.data;
        if(moving2!=null) sum+=moving2.data;
        ListNode newNode = new ListNode((sum % 10)); // sum % 10 gives the value that ca be added
        carry = sum/10; // it gives the the carry
        current.next = newNode;
        current = newNode;

        if(moving1!=null) moving1 = moving1.next;
        if(moving2!=null) moving2 = moving2.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode; 
        }

        return dummyNode.next;
    }


    //! Add 1 Number and return the list
    //! TC: O(3N) SC: O(1)
    static ListNode addOne(ListNode head){
        if(head == null) return new ListNode(1);
        // O(n)
        head = reverseLL(head);
        ListNode mover = head;
        int sum = 0;
        int carry = 1;
        // O(n)
        while(mover!=null){
            sum = carry + mover.data;
            mover.data = sum % 10;
            carry = sum/10;
            mover = mover.next;
        }

        //  O(n)
        if(carry!=0){
            head = reverseLL(head);
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            return newNode;
        }
        head = reverseLL(head);
        return head;
        
    }
    private static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.makeSinglyLinkedList(new int [] {9,9,9});
        head = ListNode.addOne(head);
        ListNode.LinkedListTraversal(head);
    }
}
