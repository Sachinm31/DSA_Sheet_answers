package LinkedList;

public class DeleteKeyInCircularList {
    /*
    Q. Delete the first node with given key in a Circular Singly Linked List.

    Example:
        List: 10 -> 20 -> 30 -> 40 -> back to 10
        key = 30
        Output: 10 -> 20 -> 40 -> back to 10

    STEPS:
    1. If list is empty → return null.
    2. If head contains the key:
          - If single node → return null.
          - Else, find last node and update head.
    3. Otherwise, search for key using a loop until we come back to head.
    4. When found → skip that node: prev.next = curr.next.
*/

    class Solution {
        Node deleteNode(Node head, int key) {

            // Case 1: empty list
            if (head == null) return null;

            Node curr = head;
            Node prev = null;

            // Case 2: head itself holds the key
            if (head.data == key) {
                // If only one node
                if (head.next == head) {
                    return null;
                }

                // Find last node to update circular link
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }

                // Move head and adjust last node link
                last.next = head.next;
                head = head.next;
                return head;
            }

            // Case 3: search for key in list
            curr = head.next;
            prev = head;

            while (curr != head) { // stops when completed full circle
                if (curr.data == key) {
                    prev.next = curr.next;
                    return head;
                }
                prev = curr;
                curr = curr.next;
            }

            // Key not found → return original list
            return head;
        }
    }

}
