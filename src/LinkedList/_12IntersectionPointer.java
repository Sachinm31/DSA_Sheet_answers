package LinkedList;
/*
 * Intersection of Two Y-Shaped Linked Lists
 * Approach: Two Pointer Switching Technique
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 *
 * Key Idea:
 * - Use two pointers p1 and p2 that traverse both lists.
 * - When a pointer reaches the end of its list, redirect it to the head of the other list.
 * - This balances the difference in lengths and guarantees they meet at the intersection node.
 *
 * IMPORTANT:
 * - Compare nodes by reference (p1 == p2), not by value.
 * - We return the intersecting Node (same memory address), not just the equal value.
 */

public class _12IntersectionPointer {
    // Function to find intersection point of two linked lists (Y-shaped)
// Approach: Two Pointer Switching Technique
// Time: O(n + m), Space: O(1)
    public static Node findIntersection(Node head1, Node head2) {

        // If any list is empty, intersection doesn't exist
        if (head1 == null || head2 == null) return null;

        Node p1 = head1;  // pointer for list A
        Node p2 = head2;  // pointer for list B

        /*
         * Move both pointers step by step.
         * When one pointer reaches the end, redirect it to the start of the other list.
         * This equalizes the travel distance and ensures they meet at the intersection.
         *
         * Compare real nodes (p1 == p2), NOT data values.
         */
        while (p1 != p2) {

            // if p1 reaches end -> move to head2, else p1.next
            p1 = (p1 == null) ? head2 : p1.next;

            // if p2 reaches end -> move to head1, else p2.next
            p2 = (p2 == null) ? head1 : p2.next;
        }

        // p1 (or p2) is now the intersection node (or null if no intersection)
        return p1;
    }

}
