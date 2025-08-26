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

        ListNode lastNode = reverseList(head.next);
        lastNode.next = head;
        head.next = null;
        return head;
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


}

