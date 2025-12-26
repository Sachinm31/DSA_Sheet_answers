package LinkedList;
/*
==============================================
LeetCode 328: Odd Even Linked List
==============================================

Problem Statement:
------------------
You are given the head of a singly linked list.
Group all the nodes at odd positions together followed by the nodes at even positions,
and return the reordered list.

⚠️ Important:
- The node values should NOT be changed.
- Only the links between nodes should be rearranged.
- The first node is considered at position 1 (odd).

----------------------------------------------
Example:
Input:
1 -> 2 -> 3 -> 4 -> 5 -> null

Output:
1 -> 3 -> 5 -> 2 -> 4 -> null

----------------------------------------------
Approach (Pointer Re-linking):
------------------------------
1. Maintain two pointers:
   - odd  → to track odd-positioned nodes
   - even → to track even-positioned nodes

2. Store the head of the even list (evenHead),
   so it can be attached after the odd list.

3. Traverse the list:
   - Link odd nodes together
   - Link even nodes together

4. After traversal, attach the even list to the end of the odd list.

----------------------------------------------
Why this works:
---------------
- We preserve the relative order of odd and even nodes.
- We rearrange links, not values.
- We perform the operation in one pass.

----------------------------------------------
Time & Space Complexity:
------------------------
Time Complexity  : O(n)
Space Complexity : O(1)

--------------------------


 */
public class _7OddEvenSegregation {
    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd=odd.next;

            even.next=odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
