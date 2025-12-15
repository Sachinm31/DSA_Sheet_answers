package LinkedList;

import java.util.HashSet;
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/
public class RemoveDupFromUnsortedList {
    public Node removeDuplicates(Node head) {
        // Your code here
        HashSet<Integer>set = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while(curr!=null){
            if(set.contains(curr.data)){
                prev.next=curr.next;
            }else{
                set.add(curr.data);
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}
