package LinkedList;

public class FindFirstNodeInLoop {
    /*
class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
};
*/

        public int cycleStart(Node head) {
            // code here
            if(head==null || head.next==null){
                return -1;
            }

            Node s= head;
            Node f = head;

            while(f!=null && f.next!=null){
                s=s.next;
                f=f.next.next;

                if(s==f){
                    break;
                }
            }

            if(f==null || f.next==null){
                return -1;
            }
            s= head;

            while(s!=f){
                s=s.next;
                f=f.next;
            }

            return s.data;
        }

}
