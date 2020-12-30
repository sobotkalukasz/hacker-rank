package pl.lsobotka.hacker.rank.daysofcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.hackerrank.com/challenges/30-binary-trees/problem
 * */
public class BinarySearchTreeTraversal {

    private static Queue<String> queue = new LinkedList<>();

    static void levelOrder(Node root) {
        queue = new LinkedList<>();
        int height = getHeight(root);
        int level = -1;
        while (level++ < height) {
            fillQueue(root, level);
        }

        System.out.println(String.join(" ", queue));
    }

    private static void fillQueue(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            queue.add(String.valueOf(root.data));
        } else {
            fillQueue(root.left, level - 1);
            fillQueue(root.right, level - 1);
        }
    }

    public static int getHeight(Node root) {
        if (root != null) {
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            return (left > right ? ++left : ++right);
        }
        return -1;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        int[] ints = new int[]{3, 5, 4, 7, 2, 1};
        Node root = null;
        for (int data : ints) {
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
