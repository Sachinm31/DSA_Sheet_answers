package LinkedList;
/*
IMPORTANT POINTS – SORT 0s, 1s, 2s IN LINKED LIST

1️⃣ Values are LIMITED (0,1,2) → No need for merge sort

2️⃣ Best approach = COUNTING
   - One pass to count
   - One pass to overwrite

3️⃣ Do NOT create new nodes
   - Modify existing nodes only

4️⃣ Time Complexity = O(n)
   Space Complexity = O(1)

5️⃣ This is NOT comparison-based sorting
   - It's segregation / counting sort idea

6️⃣ Interviewer checks:
   - Can you avoid unnecessary sorting?
   - Can you use constraints smartly?

*/

public class _11SortList0s1s2s {
    public Node segregate(Node head) {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        Node start = head;

        while (start != null) {
            if (start.data == 0) {
                count0++;
            } else if (start.data == 1) {
                count1++;
            } else {
                count2++;
            }
            start = start.next;
        }

        start = head;

        while (count0 > 0) {
            start.data = 0;
            start = start.next;
            count0--;
        }
        while (count1 > 0) {
            start.data = 1;
            start = start.next;
            count1--;
        }
        while (count2 > 0) {
            start.data = 2;
            start = start.next;
            count2--;
        }
        return head;
    }
}
