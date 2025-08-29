package LinkedList_Aug22.doubleLinkedList_29Aug;

public class Solutions {
    static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    public static void main(String[] args) {

    }

    static Node deleteAllOccurOfX(Node head, int x) {
        if (head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;
            if (temp.val == x) {
                if (temp.prev == null) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                else if (temp.next == null) {
                    temp.prev.next =  null;
                    temp.prev = null;
                }else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp.prev =  null;
                    temp.next = null;
                }
            }

            temp = nextNode;
        }

        return head;
    }

    /*
    * I can solve this problem using extra space by constructing a new Double Linked List.
    * Use Linear search and skip all the nodes which have the value x.
    * Create a fake node and Iterate an entire list.
    * If the current node has the value x, then skip it.
    * Add the current node to the new list.
    * update the fake pointer.
    *  */
    //!  TC: O(n)
    // ? SC: O(1)
}
