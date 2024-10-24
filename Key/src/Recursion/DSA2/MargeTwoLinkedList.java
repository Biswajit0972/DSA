package Recursion.DSA2;

public class MargeTwoLinkedList {
    public static class  ListNode {
        int val;
        ListNode next;

        public  ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode margeTwoList (ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list1;
        }

        if (list2 == null) {
            return list2;
        }

        if (list1.val <=list2.val) {
            list1.next = margeTwoList(list1.next, list2);
            return list1;
        }

        list2.next = margeTwoList(list1, list2.next);
        return list2;
    }
    public static void main(String[] args) {
       ListNode list1 = new ListNode(2);
       list1.next = new ListNode(3);
       list1.next.next = new ListNode(6);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(5);

        System.out.println(margeTwoList(list1, list2).val);
    }
}
