package LinkedList;

public class _15RotateLL {
    /*
==============================================
PROBLEM STATEMENT 1 (LEFT ROTATION - GFG)

Given the head of a singly linked list and an integer k,
rotate the linked list to the LEFT (anti-clockwise) by k nodes.

Example:
Input:
10 -> 20 -> 30 -> 40 -> 50
k = 4

Output:
50 -> 10 -> 20 -> 30 -> 40

Explanation:
Move the first k nodes to the end of the list.

Constraints:
- 1 ≤ number of nodes ≤ 10^5
- 0 ≤ k ≤ 10^9
==============================================
*/

    class Solution {

        // LEFT ROTATION (Anti-clockwise)
        public Node rotateLeft(Node head, int k) {

            if (head == null || head.next == null || k == 0)
                return head;

            // Step 1: Find length and tail
            Node tail = head;
            int length = 1;

            while (tail.next != null) {
                tail = tail.next;
                length++;
            }

            // Step 2: Normalize k
            k = k % length;
            if (k == 0) return head;

            // Step 3: Make list circular
            tail.next = head;

            // Step 4: Find new tail (k-1)
            Node newTail = head;
            for (int i = 0; i < k - 1; i++) {
                newTail = newTail.next;
            }

            // Step 5: Break circle
            Node newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }


/*
==============================================
PROBLEM STATEMENT 2 (RIGHT ROTATION - LEETCODE 61)

Given the head of a singly linked list and an integer k,
rotate the linked list to the RIGHT by k nodes.

Example:
Input:
1 -> 2 -> 3 -> 4 -> 5
k = 2

Output:
4 -> 5 -> 1 -> 2 -> 3

Explanation:
Move the last k nodes to the front of the list.

Constraints:
- 0 ≤ k ≤ 10^9
- The list may be empty or contain one node
==============================================
*/

        // RIGHT ROTATION (Clockwise)
        public Node rotateRight(Node head, int k) {

            if (head == null || head.next == null || k == 0)
                return head;

            // Step 1: Find length and tail
            Node tail = head;
            int length = 1;

            while (tail.next != null) {
                tail = tail.next;
                length++;
            }

            // Step 2: Normalize k
            k = k % length;
            if (k == 0) return head;

            // Step 3: Make list circular
            tail.next = head;

            // Step 4: Find new tail (length - k - 1)
            int stepsToNewTail = length - k - 1;
            Node newTail = head;

            for (int i = 0; i < stepsToNewTail; i++) {
                newTail = newTail.next;
            }

            // Step 5: Break circle
            Node newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }
    }
}
