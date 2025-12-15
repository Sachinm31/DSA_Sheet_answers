package LinkedList;
;
import java.util.*;

public class ReorderList {
    public static void reorder(ListNode head){
        if(head==null || head.next ==  null) return;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode first = head;

        ListNode second = reverse(slow.next);
        slow.next = null;

        while(second.next!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next=second;
            second.next=tmp1;

            first=tmp1;
            second = tmp2;
        }

    }
    public static ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
