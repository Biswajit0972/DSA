package LinkedList_Aug22;

public class Solutions {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x;
        next = null;}
    }
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast =  head;

        while (fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
