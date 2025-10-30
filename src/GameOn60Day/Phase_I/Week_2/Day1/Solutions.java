package GameOn60Day.Phase_I.Week_2.Day1;


public class Solutions {
    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode() {
        }

        ;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public int getLen(ListNode head) {
            if (isNull(head)) return 0;

            int len = 0;
            ListNode temp = head;

            while (temp != null) {
                len++;
                temp = temp.next;
            }

            return len;
        }

        public boolean isNull(ListNode head) {
            return head == null;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) return null;

            ListNode temp = head;
            ListNode dummy = null;

            while (temp != null) {
                ListNode tempNext = temp.next;
                temp.next = dummy;
                dummy = temp;
                temp = tempNext;
            }

            return dummy;
        }

        public void printList(ListNode head) {
            if (head == null) {
                return;
            }

            ListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ->");
                temp = temp.next;
            }
            System.out.println("NUll");
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (isNull(head)) return null;

            int size = getLen(head);

            if (size == k) {
                return reverseList(head);
            }

            //! if k is less than of length of the linkedList

            int group = 0;

            boolean trackHead = false;

            ListNode temp = head;
            ListNode groupHead = head;
            ListNode newHead = null;
            ListNode prev = null;

            while (temp != null) {
                group++;

                if (group == k) {
                    ListNode tempNext = temp.next;
                    ListNode revGroup = reverseList(groupHead, temp);

                    if (!trackHead) {
                        newHead = temp;
                        trackHead = true;
                    }

                    if (prev != null) {
                        prev.next = temp;
                    }

                    prev = revGroup;
                    revGroup.next = tempNext;

                    groupHead = tempNext;
                    group = 0;
                    temp = tempNext;
                    continue;
                }

                temp = temp.next;
            }

            return newHead;
        }

        public ListNode reverseList(ListNode head, ListNode stop) {
            boolean trackTail = false;

            ListNode temp = head;
            ListNode dummy = null;
            ListNode tail = null;

            while (temp != null) {
                ListNode tempNext = temp.next;
                temp.next = dummy;
                dummy = temp;
                if (!trackTail) {
                    tail = dummy;
                    trackTail = true;
                }
                if (temp == stop) {
                    break;
                }
                temp = tempNext;
            }

            return tail;
        }
    }

    public static void main(String[] args) {
        ListNode e1 = new ListNode(1);
        e1.next = new ListNode(2);
        e1.next.next = new ListNode(3);
        e1.next.next.next = new ListNode(4);
        e1.next.next.next.next = new ListNode(5);
        e1.printList(e1);
        ListNode temp = e1.reverseKGroup(e1, 5);
        e1.printList(temp);
    }
}
