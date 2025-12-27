package LinkedList;
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
/*
============================================================
Problem Statement: Add 1 to a Number Represented by Linked List
============================================================

You are given a singly linked list where each node contains
a single digit (0–9). The digits of the number are stored in
forward order, i.e., the most significant digit comes first.

Your task is to add 1 to the number represented by the linked
list and return the head of the updated linked list.

------------------------------------------------------------
Constraints:
- The linked list is non-empty
- Each node contains a digit between 0 and 9
- The number does not contain leading zeros
- You must correctly handle carry propagation
- The length of the linked list may increase after addition

------------------------------------------------------------
Examples:

Input:  1 -> 2 -> 3
Output: 1 -> 2 -> 4
Explanation: 123 + 1 = 124

Input:  9 -> 9 -> 9
Output: 1 -> 0 -> 0 -> 0
Explanation: 999 + 1 = 1000

Input:  4 -> 5 -> 9
Output: 4 -> 6 -> 0
Explanation: 459 + 1 = 460

------------------------------------------------------------
Expected Time Complexity:
O(n), where n is the number of nodes in the linked list

Expected Auxiliary Space:
O(1), excluding space used for the new node (if created)

------------------------------------------------------------
Approach Used:
1. Reverse the linked list to process addition from the
   least significant digit.
2. Add 1 and propagate carry if needed.
3. Create a new node if carry remains after the last digit.
4. Reverse the linked list again to restore original order.
============================================================
*/

public class _13Add_1_to_LL_num {
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;

    }
    public Node addOne(Node head) {
        if(head==null) return head;
        // code here.
        head = reverse(head);

        Node curr = head;
        int carry = 1;

        while(curr!=null){
            int sum = curr.data+carry;
            curr.data = sum%10;
            carry = sum/10;

            if(carry==0) break;

            if(curr.next==null && carry>0){
                curr.next=new Node(carry);
                carry = 0;
                break;
            }

            curr=curr.next;
        }
        head = reverse(head);
        return head;

    }
}
