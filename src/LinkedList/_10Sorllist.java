package LinkedList;
/*
==================== IMPORTANT POINTS – MERGE SORT ON LINKED LIST ====================

1️⃣ WHY MERGE SORT?
   - Linked List has NO random access → QuickSort is inefficient
   - Merge Sort works in O(n log n) and merges in O(1) extra space

2️⃣ BASE CASE (MOST IMPORTANT)
   - If head == null OR head.next == null → already sorted
   - Missing this leads to infinite recursion

3️⃣ FINDING MID (CRITICAL DETAIL)
   - Use slow = head, fast = head.next
   - NOT fast = head ❌
   - This guarantees left half is smaller and recursion converges

   Pattern:
     slow moves 1 step
     fast moves 2 steps

4️⃣ BREAK THE LIST
   - Always do:
       rightHead = mid.next
       mid.next = null
   - If you forget this → infinite loop / wrong merge

5️⃣ RECURSION STRUCTURE
   - left = mergeSort(head)
   - right = mergeSort(rightHead)
   - Think: Divide → Sort → Merge

6️⃣ MERGE TWO SORTED LISTS
   - Use dummy node to simplify pointer handling
   - Always move curr pointer after linking a node

7️⃣ ATTACH REMAINING NODES
   - After loop, exactly ONE list may be non-null
   - Do:
       curr.next = (h1 != null) ? h1 : h2

8️⃣ TIME & SPACE COMPLEXITY
   - Time: O(n log n)
   - Space: O(log n) → recursion stack only
   - No extra arrays allowed

9️⃣ COMMON INTERVIEW MISTAKES ❌
   - Using fast = head
   - Forgetting mid.next = null
   - Creating new nodes instead of reusing existing ones
   - Returning mid instead of dummy.next

10️⃣ INTERVIEWER EXPECTATION 🧠
   - Correct mid logic
   - Clean merge
   - In-place pointer manipulation
   - Clear base case reasoning

=====================================================================================
*/

public class _10Sorllist {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode midNext = mid.next;
        mid.next = null; // disconnect the first half and the second half
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        return mergeTwoLists(left, right);
    }

    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head.next;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dup = new ListNode(0);
        ListNode tail = dup;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }
        return dup.next;
    }
}
