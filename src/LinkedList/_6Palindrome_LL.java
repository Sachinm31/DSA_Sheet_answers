package LinkedList;

public class _6Palindrome_LL {
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
    static ListNode rev(ListNode head){
        ListNode a = head;
        if (a == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = null;
        while (a != null) {
            next = a.next;
            a.next = prev;
            prev = a;
            a = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fs = head;
        ListNode sl = head;
        while (fs != null && fs.next != null) {
            fs = fs.next.next;
            sl = sl.next;
        }
        sl = rev(sl);
        ListNode temp = head;
        while (sl != null) {
            if (temp.val != sl.val) {
                return false;
            }
            temp = temp.next;
            sl = sl.next;
        }
        return true;
    }

}
