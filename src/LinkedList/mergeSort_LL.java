package LinkedList;

public class mergeSort_LL {

    public static Node mergeSort(Node head) {

        // Base case: if list empty or only one element -> already sorted
        if (head == null || head.next == null)
            return head;

        // Step 1: Find middle of the list
        Node mid = getMiddle(head);
        Node secondHalf = mid.next;
        mid.next = null; // break the list into two halves

        // Step 2: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(secondHalf);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // -------- Helper Function to find middle element using slow & fast pointers --------
    private static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;  // fast starts one step ahead

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  // slow is middle node
    }

    // -------- Helper Function to merge two sorted linked lists --------
    private static Node merge(Node a, Node b) {

        // Dummy node to build final sorted list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Compare and merge
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes if any
        if (a != null) tail.next = a;
        if (b != null) tail.next = b;

        return dummy.next;
    }

}
