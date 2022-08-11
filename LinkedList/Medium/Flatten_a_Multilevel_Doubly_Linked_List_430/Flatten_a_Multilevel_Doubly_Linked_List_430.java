package DSApractice.LinkedList.Medium.Flatten_a_Multilevel_Doubly_Linked_List_430;

public class Flatten_a_Multilevel_Doubly_Linked_List_430 {

    public Node flatten(Node head) {
        Node node = head;

        // first find a node that has child != null;
        while (node != null) {
            if (node.child != null) {
                solution(node);
            }

            node = node.next;
        }

        return head;
    }

    public void solution(Node node) {
        // tail will traverse in the one below level node
        Node tail = node.child;
        // this to make the node (tail) doubly linked
        tail.prev = node;

        // find the last node
        while (tail.next != null) {
            tail = tail.next;
        }

        // then we make next of last node as node.next (parents next)
        tail.next = node.next;
        // if parents next is not null, point the prev to tail -> doubly linked
        if (tail.next != null) {
            tail.next.prev = tail;
        }

        // make node's (parents next) to its child and make node.child as null
        node.next = node.child;
        node.child = null;
    }
}