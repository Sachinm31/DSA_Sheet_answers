package LinkedList;

public class _14Add_2number_LL {
    //You are given the head of two singly linked lists head1 and head2 representing two non-negative integers. You have to return the head of the linked list representing the sum of these two numbers.
    //Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
    /*
   class Node {
       int data;
       Node next;

       Node(int d) {
           data = d;
           next = null;
       }
   }
   */
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addTwoLists(Node head1, Node head2) {
        // code here
        while(head1!=null && head1.data==0) head1=head1.next;
        while(head2!=null && head2.data==0) head2=head2.next;

        if(head1==null && head2==null) return new Node(0);

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while(head1!=null || head2!=null || carry>0){
            int sum = carry;

            if(head1!=null){
                sum=sum+head1.data;
                head1=head1.next;
            }
            if(head2!=null){
                sum=sum+head2.data;
                head2=head2.next;
            }
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr=curr.next;
        }
        return reverse(dummy.next);
    }
}
