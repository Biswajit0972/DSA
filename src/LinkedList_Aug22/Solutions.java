package LinkedList_Aug22;


public class Solutions {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x;
        next = null;}
    }
    public static void main(String[] args) {
        System.out.println( 1 == 0 || 1==0);
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = listSize(headA);
        int sizeB = listSize(headB);

        ListNode slow;
        ListNode fast;

        if (sizeA > sizeB) {
            fast = headA;
            slow = headB;
        }else {
            fast = headB;
            slow = headA;
        }

        for (int i = 0; i < Math.abs(sizeA-sizeB); i++) {
            fast = fast.next;
        }

        while (fast != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return null;
    }

    public ListNode addOne(ListNode head) {
      if (head == null) {
          return null;
      }

      ListNode revList  = reverseListUsingIteration(head);
      boolean carry = true;

      ListNode temp = revList;

      while (temp != null) {
          int sum = temp.val + (carry? 1 : 0);
          carry = sum >= 10;
          temp.val = sum % 10;
          temp = temp.next;
      }

      ListNode  resultList = reverseListUsingIteration(revList);

      if (carry) {
          ListNode newHead = new ListNode(1);
          newHead.next = resultList;
          return newHead;
      }

      return resultList;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode  p2 = l2;
        ListNode  p3 = dummy;

        int carray = 0;

        while (p1 != null || p2 != null) {
            int sum = carray + (p1 == null? 0 : p1.val) + (p2 == null? 0 : p2.val);
            carray = sum >= 10? 1 : 0;
            sum = sum % 10;
            p3.next = new ListNode(sum);
            p3 = p3.next;

            p1 = p1 == null? null  : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        if (carray != 0) {
            p3.next = new ListNode(carray);
        }

        return dummy.next;
    }

    public ListNode segregate(ListNode head) {
        // code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);

        ListNode p1 = zero;
        ListNode p2 = one;
        ListNode p3 = two;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                p1.next = temp;
                p1 = p1.next;
            }else if (temp.val == 1) {
                p2.next = temp;
                p2 = p2.next;
            }else {
                p3.next = temp;
                p3 = p3.next;
            }

            temp = temp.next;
        }

        p1.next = (one.next == null? two.next : one.next);
        p2.next = two.next;
        p3.next = null;
        return zero.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode  right = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return mergeList( left,  right) ;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);

        ListNode p3 = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p3.next = l1;
                p3 = p3.next;
                l1 = l1.next;
            }else {
                p3.next = l2;
                p3 = p3.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            p3.next = l1;
        }
        if (l2 != null) {
            p3.next = l2;
        }

        return dummy.next;
    }
}

