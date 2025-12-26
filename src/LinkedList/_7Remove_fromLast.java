package LinkedList;

public class _7Remove_fromLast {
    public static ListNode remove(ListNode head,int n){
//        ListNode head = new ListNode(0);
//        head.next = head;
        ListNode start = head;
        ListNode end = head;

        for (int i=0;i<=n;i++){
            end = end.next;
        }
        while(end != null){
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
        return head;
    }
}
