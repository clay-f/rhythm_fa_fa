package com.f.resolved;

import java.util.Objects;

import static com.f.rhythm.helper.SortHelper.less;

public class NodeTask {
    public static void main(String[] args) {
        Node node = new Node("a").buildNextNode("b");

        for (Node item = node.reverse(); item != null; item = item.next) {
            System.out.println(item.item);
        }
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

    public static void insertAfter(Node target, Node second) {
        if (target == null) return;
        if (target.next == null) {
            target.next = second;
        } else {
            insertAfter(target.next, second);
        }
    }

    public static void remove(Node node, String key) {
        if (node == null) return;
        if (node.next != null && node.next.item.equals(key)) {
            node.next = node.next.next;
            remove(node.next, key);
        } else {
            remove(node.next, key);
        }
    }

    public static String max(Node node) {
        if (node == null) return "";
        return max(node, "");
    }

    public static String max(Node node, String max) {
        if (node == null) return max;
        if (!less(node.item, max)) {
            max = node.item;
            return max(node.next, max);
        } else {
            return max(node.next, max);
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

        public void removeAfter(Node node) {
            if (node == null) return;
            removeAfter(this, node);
        }

        private void removeAfter(Node current, Node target) {
            if (current == null) return;
            if (current.item.equals(target.item)) {
                current.next = null;
                return;
            } else {
                removeAfter(current.next, target);
            }
        }

        public Node reverse() {
            return reverse(this, null);
        }

        private Node reverse(Node current, Node prev) {
            if (current == null) return prev;
            Node next = current.next;
            current.next = prev;
            prev = current;
            return reverse(next, prev);
        }
    }


}
