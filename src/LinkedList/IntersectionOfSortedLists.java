package LinkedList;
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
public class IntersectionOfSortedLists {
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node curr = dummy;



        Node p1 = head1;
        Node p2 = head2;

        while(p1!=null && p2 != null){
            if(p1.data==p2.data){
                curr.next = new Node(p1.data);
                curr = curr.next;

                p1=p1.next;
                p2=p2.next;

            }else if(p1.data>p2.data){
                p2=p2.next;
            }else{
                p1= p1.next;
            }
        }
        return dummy.next;
    }
}
