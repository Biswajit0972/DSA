package LinkedList.Day1;

public class RotateLinked {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next =  null;
        }
    }

    public static void printList (ListNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print(head.val + "->");
        printList(head.next);
    }

    public static ListNode rotateList (ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head, prev = null, next;

        while (curr != null) {
            // store current node next
            next = curr.next;
            // now point curr next null because after reverse first go to the last;
            curr.next = prev;

            // store current node into the prev
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode sum (ListNode list1, ListNode list2) {
        list1 = rotateList(list1);
        list2 = rotateList(list2);

        int sum = value(list1) + value(list2);
        System.out.println(sum);
        ListNode dm = new ListNode(-1);
        ListNode temp = dm;
        while (sum != 0) {
            int last = sum % 10;
            temp.next = new ListNode(last);
            temp = temp.next;
            sum /= 10;
        }
        return dm.next;
    }

    public static int value (ListNode list) {
        ListNode temp = list;
        int res = 0;

        while (temp != null) {
            res = (res * 10) + temp.val;
            temp = temp.next;
        }

        return res;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        printList(sum(l1, l2));
    }
}
