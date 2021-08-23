/*
Given a singly linked list, remove all the nodes which have a greater value on its right node.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on the following nodes. So, after deleting
them, the linked list would like be 15,
11, 6, 3.
Example 2:

Input:
LinkedList = 10->20->30->40->50->60
Output: 60
Your Task:
The task is to complete the function compute() which should modify the list as required and return the head of the modified linked list. The printing is done by the driver code,

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ size of linked list ≤ 1000
1 ≤ element of linked list ≤ 1000
Note: Try to solve the problem without using any extra space.
*/


class Node{
    int val;
    Node next;
    Node(){}
    Node(int val){
        this.val = val;
        this.next = null;
    }
    Node(Node next, int val){
        this.val = val;
        this.next = next;
    }

}

public class Main1{
    public static void main(String[] args) {
        // Node head = new Node(12);
        // head.next = new Node(15);
        // head.next.next = new Node(10);
        // head.next.next.next = new Node(11);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        // head.next.next.next.next.next.next = new Node(2);
        // head.next.next.next.next.next.next.next = new Node(3);

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        
        Node modifiedListNode = deleteSmallerNode(head);
        printTheLinkedList(modifiedListNode);
    }

    public static Node  deleteSmallerNode(Node head){

        Node curr = head;
        Node pre = null;

        while(curr.next != null){
            if(curr.val < curr.next.val){
                if(pre == null){
                    head = curr.next;
                    curr = curr.next;
                }else{
                    pre.next = curr.next;
                    curr = curr.next;
                }
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printTheLinkedList(Node head){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
}