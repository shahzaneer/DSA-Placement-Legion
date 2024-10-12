public class LinkedList {
    public static void main(String[] args) {
        Node head = Node.makeSinglyLinkedList(new int []{1,2,3,4,5,6,7});
    
        // Node.LinkedListTraversal(head);
        // System.out.println(Node.lengthOfLL(head));
        // System.out.println(Node.searchInLL(head, 7));

        // head = Node.insertNode(head, 0, 8);
        // head = Node.insertNode(head, 4, 12);
        // head = Node.insertNode(head,7,99);
        // head = Node.insertNode(head,17,99);
        head = Node.reverseLinkedListIterative(head); //working fine
        head = Node.reverseLinkedListRecursive(head); //working fine
        Node.LinkedListTraversal(head);
    }
}
