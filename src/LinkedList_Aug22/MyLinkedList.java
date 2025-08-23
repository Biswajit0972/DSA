package LinkedList_Aug22;

public class MyLinkedList {
    class Node  {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;
    int current_size = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= current_size) {
            return -1;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        current_size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        current_size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == current_size) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        current_size++;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            current_size--;
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }
}