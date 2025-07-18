package Jeca.CustomLinkedList;

public class Solution {
    static class Node  {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node head = null,  tail = null;

    public static void addFirst ( int data) {
        Node newNode = new Node(data);

        if (head == null)   {
            head  =  tail =  newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public static void addLast (int data) {
        Node newNode  = new Node(data);
        if (head== null) {
            head  = tail= newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static void printList () {

        if (head ==  null) {
            System.out.println("List is empty");
        }

        Node temp =  head;

        while (temp !=  null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addFirst(1);
        addFirst(3);
         addLast(2);
         addFirst(6);
         addLast(5);
        printList();
    }
}
