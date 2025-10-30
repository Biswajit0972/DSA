package GameOn60Day.Phase_I.Week_2.Day2;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    static class ListNode {
        public int data;
        public ListNode next;
        public ListNode bottom;

        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }

        public ListNode Approch1(ListNode head) {
            if (head == null) return null;
            ArrayList<ListNode> list = new ArrayList<>();

            ListNode temp = head;
            while (temp != null) {
                ListNode temp2 = temp;
                while (temp2 != null) {
                    list.add(temp2);
                    temp2 = temp2.bottom;
                }
                ListNode tempNext = temp.next;
                 temp.next = null;
                 temp = tempNext;
            }

            list.sort((a, b) -> a.data - b.data);

            ListNode dummy = new ListNode(-1);
            ListNode temp3 = dummy;
            for (ListNode node : list) {
                dummy.bottom = node;
                dummy = dummy.bottom;
            }
            return temp3.bottom;
        }

        public ListNode Approch2(ListNode head) {
            if (head == null ||  head.next ==  null) {
                return head;
            }

            ListNode mergeHead =   Approch2(head.next);
            return mergeLists(head,mergeHead);
        }

        public ListNode mergeLists(ListNode head1, ListNode head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;

            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            while (head1 != null && head2 != null) {
                if (head1.data < head2.data) {
                    temp.bottom = head1;
                    temp = temp.bottom;
                    head1 = head1.bottom;
                } else {
                    temp.bottom = head2;
                    temp = temp.bottom;
                    head2 = head2.bottom;
                }
            }

            while (head1 != null) {
                temp.bottom = head1;
                head1 = head1.bottom;
                temp = temp.bottom;
            }

            while (head2 != null) {
                temp.bottom = head2;
                head2 = head2.bottom;
                temp = temp.bottom;
            }

            return dummy.bottom;
        }

        public void printList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.bottom;
            }
            System.out.println("Null");
        }
    }

    public static void main(String[] args) {
        ListNode e1 = new ListNode(5);
        ListNode e2 = new ListNode(10);
        ListNode e3 = new ListNode(20);

        e1.next = e2;
        e2.next = e3;

        e1.bottom = new ListNode(7);
        e1.bottom.bottom = new ListNode(8);

        e2.bottom = new ListNode(15);
        e2.bottom.bottom = new ListNode(17);

        e3.bottom = new ListNode(25);
        e3.bottom.bottom = new ListNode(27);

        e1.printList(e1);
        ListNode temp = e1.Approch2(e1);
        e1.printList(temp);
    }
}
