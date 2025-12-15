package LinkedList;

public class removeLoop {

    // Function to remove loop from linked list
    public static void removeLoop(Node head) {

        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        boolean loopExists = false;

        // Step 1: Detect loop using Floyd's Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) return;  // No loop found

        // Step 2: Find the start of loop
        slow = head;

        // If loop starts at head
        if (slow == fast) {
            // Move fast until the last node of loop
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            // Normal case
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Break the loop
        fast.next = null;
    }

    // Test the code
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop manually: last node points to node 3
        head.next.next.next.next.next = head.next.next;

        System.out.println("Loop removal running...");
        removeLoop(head);

        // Printing list to verify loop is removed
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}