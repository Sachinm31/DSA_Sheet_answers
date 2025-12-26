package LinkedList;

public class _5DetectLoopLength {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return countLength(slow);
            }
        }
        return 0;
    }
    public int countLength(Node entry){
        Node temp = entry.next;
        int count = 1;
        while(entry!=temp){
            count++;
            temp=temp.next;
        }
        return count;
    }
}
