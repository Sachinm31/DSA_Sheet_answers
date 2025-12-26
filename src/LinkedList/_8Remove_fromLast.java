package LinkedList;

public class _8Remove_fromLast {
    public static ListNode remove(ListNode head,int n){
//        ListNode head = new ListNode(0);
//        head.next = head;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        ListNode end = dummy;

        for (int i=0;i<n;i++){
            end = end.next;
        }
        while(end.next!= null){
            start=start.next;
            end=end.next;
        }
        start.next = start.next.next;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        return dummy.next;
    }
}
