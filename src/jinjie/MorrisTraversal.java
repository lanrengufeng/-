package jinjie;

public class MorrisTraversal {
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void process(Node head) {
        if (head == null) {
            return;
        }
        // 1
        //System.out.println(head.value);
        process(head.left);
        // 2
        //System.out.println(head.value);
        process(head.right);
        // 3
        //System.out.println(head.value);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void morrisIn(Node root) {
        if (root == null)
            return;
        Node mostRight = null;
        while (root != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != root)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else
                    mostRight.right = null;
            }
            System.out.print(root.value + " ");
            root = root.right;
        }
        System.out.println();
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void morrisPre(Node root) {
        if (root == null)
            return;
        Node mostRight = null;
        while (root != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != root)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    System.out.print(root.value + " ");
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else
                    mostRight.right = null;
            } else
                System.out.print(root.value + " ");
            root = root.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历
     *
     * @param head
     */
    public static void morrisPos(Node head) {
        if (head == null)
            return;
        Node mostRight = null;
        Node root = head;
        while (root != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != root)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(root.left);
                }
                mostRight.right = null;
            }
            root = root.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(Node root) {
        if (root == null)
            return;
        Node tail = reverse(root);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverse(tail);
    }

    private static Node reverse(Node root) {
        if (root == null)
            return null;
        Node pre = null, next;
        while (root != null) {
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

    private static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        printTree(head);
    }
}
