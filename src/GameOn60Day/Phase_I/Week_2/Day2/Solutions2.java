package GameOn60Day.Phase_I.Week_2.Day2;

import java.util.HashMap;

public class Solutions2 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            HashMap<Node, Node> map = new HashMap<>();
            Node temp = head;
            while (temp != null) {
                map.put(temp, new Node(temp.val));
                temp = temp.next;
            }

            Node dummy = map.get(head);

            for (Node node : map.keySet()) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
            }

            return dummy;
        }
    }

    public static void main(String[] args) {

    }
}
