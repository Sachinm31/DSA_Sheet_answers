package LinkedList;
//class Node {
//    int data;
//    Node next;
//
//    Node(int x) {
//        data = x;
//        next = null;
//    }
//}
public class MoveLastNodeToFront {
    static Node moveToFront(Node head) {

        // If the list is empty or has only one node,
        // no need to move
        if (head == null || head.next == null) {
            return head;
        }

        // To keep track of the second last node
        Node secLast = null;

        // To traverse to the last node
        Node last = head;

        // Traverse the list to find the last and
        // second last nodes
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        // Change the next of second last node to null
        secLast.next = null;

        // Make the last node as the new head
        last.next = head;
        head = last;

        return head;
    }
}
