package LinkedList;
/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
public class removeDuplicates {
    Node removeDuplicate(Node head) {
        // Your code here
        Node curr = head;

        while(curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
}
