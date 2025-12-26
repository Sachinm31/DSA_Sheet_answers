package LinkedList;

public class _2ReverseLinkedlist {
    public static ListNode reverse(ListNode head){
        if(head==null) return head;
        ListNode prev = null;
        ListNode present = head;
        ListNode next =  present.next;

        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null){
                next=next.next;
            }
        }
        ListNode temp = prev;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        return prev;
    }
}
