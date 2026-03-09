package _2026.LinkedList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

class Solution {
   public ListNode removeKthNode (ListNode head, int k) {
       if (head == null || k <= 0 || k == 1) return null;

       ListNode prev = null;
       ListNode curr = head;
       int count = 1;

       while (curr != null) {
           if (count % k == 0) {
               prev.next = curr.next;
           }else {
               prev = curr;
           }
           curr = curr.next;
           count++;
       }

       return head;
   }

   public void printList(ListNode head) {
       if (head  == null) {
           return;
       }

       ListNode temp = head;

       while(temp !=  null) {
           System.out.print(temp.val + " " + "-> ");
           temp = temp.next;
       }
   }

   public ListNode middleNode (ListNode head) {
       if (head  == null) {
           return null;
       }

       ListNode slow = head;
       ListNode fast = head;

       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
       }

       return slow;
   }

    public static ListNode flipLinkedListUsingDummy(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;

            ListNode dummyNext = dummy.next;
            dummy.next = temp;
            temp.next = dummyNext;

            temp = next;
        }

        return dummy.next;
    }

    public static ListNode flipLinkedListUsingPointer(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

}

public class MyLinkedList {
    public static void main(String[] args) {
        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        ListNode e3 = new ListNode(3);
        ListNode e4 = new ListNode(4);
        ListNode e5 = new ListNode(5);
        ListNode e6 = new ListNode(6);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;
        e5.next = e6;
        Solution solution = new Solution();
        solution.removeKthNode(e1, 2);
        solution.printList(e1);
    }
}
