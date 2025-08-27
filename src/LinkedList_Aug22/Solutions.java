package LinkedList_Aug22;

import java.util.List;

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

    public ListNode reverseList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // ! head.next.next means null, reason in main list current head still points to next, but it's next node next points to null, internally we just change pointer.
       ListNode lastNode = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return lastNode;
    }

    public ListNode reverseListUsingIteration(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode dummy = null;

        while (temp != null) {
            ListNode currNext = temp.next;
            temp.next = dummy;
            dummy = temp;
            temp = currNext;
        }

        return dummy;
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow ;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while (fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode prevList = reverseList(head);
        while (prevList != null && fast != null) {
            if (prevList.val != fast.val) {
                return false;
            }
            prevList = prevList.next;
            fast = fast.next;
        }



        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null ) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }


        odd.next = evenHead;

        return odd;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int listSize = listSize(head);

        if (n == listSize) {
            return head.next;
        }

        ListNode temp = head;
        // ! listSize - n-1 means we are skipping n nodes from head.
        // ? previously we skipped listsize - n, here one cache: 0 to less 3 node i = 0 temp move to the second node, i = 1 move to the third node,to delete 4
        //  node  we need to stop here, but we still goes 4th node. listSize - n means 1-based indexing, but here we are fllowing 0 based indexing
        for (int i = 0; i < listSize - n-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next == null? null : temp.next.next;

        return head;
    }

    public int listSize(ListNode head) {
        if (head == null) {
            return 0;
        }

        int count = 0;

        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode  dummy = new ListNode(-1);
        dummy.next = head;

        if (head == null) {
            return null;
        }

        ListNode fast = dummy;
        ListNode slow = dummy;


        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow  = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null ||  head.next ==  null) {
            return null;
        }

        ListNode temp = head;
        int halfNode = listSize(head)  / 2;

        for (int i = 0; i < halfNode - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public ListNode deleteMiddleOnePhase(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev == null) {
           return null;
        }
        prev.next = slow.next;

        return head;
    }
}

