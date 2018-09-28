package com.f.resolved;

import java.util.Objects;

public class NodeTask {
    public static void main(String[] args) {
        Node node = new Node("a").buildNextNode("b").buildNextNode("c").buildNextNode("d").buildNextNode("e");

        System.out.println(findNodeIsExists(node, "d"));

    }

    public static void deleteLastNode(Node node) {
        if (Objects.isNull(node)) return;
        if (Objects.isNull(node.next.next)) {
            node.next = null;
        } else {
            deleteLastNode(node.next);
        }
    }

    public static void deleteIndexElement(Node node, int i) {
        if (Objects.isNull(node)) return;
        if (i == 1 + 1) {
            Node current = node;
            Node next = current.next;
            current.next = next.next;
            next.next = null;
            return;
        } else {
            deleteIndexElement(node.next, i - 1);
        }
    }

    public static boolean findNodeIsExists(Node node, String key) {
        if (node == null) return false;

        if (Objects.equals(node.item, key)) {
            return true;
        } else {
            return findNodeIsExists(node.next, key);
        }
    }

    public static class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            next = null;
        }

        public Node buildNextNode(String s) {
            Node node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(s);
            return this;
        }
    }

}
