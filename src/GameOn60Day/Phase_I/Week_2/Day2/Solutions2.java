package GameOn60Day.Phase_I.Week_2.Day2;

import java.util.HashMap;

public class Solutions2 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            //! copy the node
            Node temp = head;

            while (temp  != null ) {
                Node newNode =  new Node(temp.val);
                newNode.next = temp.next;
                temp.next = newNode;
                temp = newNode.next;
            }

            //! random pointer fixing
            temp = head;

            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }

            // * create a separated list

            temp = head;
            Node copyHead = temp.next;
            Node copy = copyHead;

            while (temp != null) {
                temp.next = copy.next;
                temp = temp.next;
                if (temp != null)  {
                    copy.next = temp.next;
                    copy = temp.next;
                }
            }
            return copyHead;
        }

        public void printList(Node head) {
            if (head == null) {
                return;
            }

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    public static void main(String[] args) {
        Node e1 = new Node(1);
        Node e2 = new Node(2);
        Node e3 = new Node(3);
        Node e4 = new Node(4);
        Node e5 = new Node(5);
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;
        e1.copyRandomList(e1);
        e1.printList(e1);
    }
}
