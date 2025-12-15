import LinkedList.ListNode;
import Tree.treeNode;

import static LinkedList.Remove_fromLast.remove;
import static LinkedList.ReorderList.reorder;
import static LinkedList.ReverseLinkedlist.reverse;
import static LinkedList.createLinkedList.createLinkedList;
import static LinkedList.createLinkedList.printList;
import static Tree.maxDepth.maxdepth;
import static java.io.ObjectInputFilter.merge;
import static LinkedList.mergeList.merge;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {10, 20, 30, 40, 50,60,70,80};
//        int arr2[] = {15,25,35,45,55,65};
//        ListNode head1 = createLinkedList(arr);
//        ListNode head2 = createLinkedList(arr2);
//
//        System.out.println("Linked List:");
//////        printList(head);
////        reverse(head1);
////        merge(head1,head2);
////        remove(head1,2);
//        reorder(head1);
//        printList(head1);
// Example tree: [3,9,20,null,null,15,7]
            treeNode root = new treeNode(3);
            root.left = new treeNode(9);
            root.right = new treeNode(20);
            root.right.left = new treeNode(15);
            root.right.right = new treeNode(7);

            System.out.println(maxdepth(root)); // Output: 3
        
    }

}