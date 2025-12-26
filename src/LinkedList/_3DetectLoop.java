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
    public static void main(String[] args) {

        DetectLoop obj = new DetectLoop();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop: last node -> node with value 3
        head.next.next.next.next.next = head.next.next;

        boolean hasLoop = obj.detectLoop(head);

        System.out.println("Loop detected: " + hasLoop);
    }
}
