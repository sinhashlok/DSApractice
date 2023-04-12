package DSApractice.LinkedList.Medium.Copy_List_with_Random_Pointer_138;

import DSApractice.LinkedList.Medium.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer_138 {
//    public static void main(String[] args) {
//        Node four = new Node(1);
//        Node three = new Node(13);
//        Node two = new Node(11);
//        Node one = new Node(-13);
//        Node root = new Node(7);
//
//        root.next = one;
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = null;
//
//        root.random = null;
//        one.random = root;
//        two.random = four;
//        three.random = two;
//        four.random = root;
//
//        root = copyRandomList(root);
//        while (root != null) {
//            System.out.print(root.val + " ");
//            root = root.next;
//        }
//    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        // first - original Node
        // second - deep copy

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            // .get(node).next/random - copied node
            // .get(node.next/random) - original node
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    public Node copyRandomListMy(Node head) {
        Node node = head, next;

        // First round: make copy of each node, and link them together side-by-side in a single list.
        while (node != null) {
            next = node.next;

            Node copy = new Node(node.val);
            node.next = copy;
            copy.next = next;

            node = next;
        }

        // Second round: assign random pointers for the copy nodes.
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        node = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (node != null) {
            next = node.next.next;

            // extract the copy
            copy = node.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            node.next = next;

            node = next;
        }

        return pseudoHead.next;
    }
}