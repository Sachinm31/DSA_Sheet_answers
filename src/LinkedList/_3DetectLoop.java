package LinkedList;




public class _3DetectLoop {

    // Floyd's Cycle Detection Algorithm
    public boolean detectLoop(Node head) {

        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps

            if (slow == fast) {
                return true;         // loop detected
            }
        }

        return false;                // no loop
    }

    // Demo main() to run and verify

}
