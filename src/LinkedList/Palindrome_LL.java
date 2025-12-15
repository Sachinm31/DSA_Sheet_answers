package LinkedList;

public class Palindrome_LL {
    /*
    Q. Check if a singly linked list is a palindrome.

    A palindrome means the list reads the same forward and backward.

    Example:
        Input: 1 -> 2 -> 2 -> 1   Output: true
        Input: 1 -> 2 -> 3        Output: false

    STEPS:
    1. Use slow & fast pointers to find middle.
    2. Reverse the second half of the list.
    3. Compare first half vs reversed second half.
    4. If all values match → palindrome.
    5. (Optional) Restore list.
*/

    public boolean isPalindrome(Node head) {

        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node firstHalfEnd = endOfFirstHalf(head);

        // Step 2: Reverse second half
        Node secondHalfStart = reverseList(firstHalfEnd.next);

        // Step 3: Compare halves
        Node p1 = head;
        Node p2 = secondHalfStart;
        boolean result = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4: Restore list
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    // Reverse linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // Find middle using slow & fast
    private Node endOfFirstHalf(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
