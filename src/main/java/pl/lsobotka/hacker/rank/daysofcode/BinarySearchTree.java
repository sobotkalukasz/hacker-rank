package pl.lsobotka.hacker.rank.daysofcode;

/*
 * https://www.hackerrank.com/challenges/30-binary-search-trees/problem
 * */
public class BinarySearchTree {

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
        int[] ints = new int[]{3, 5, 2, 1, 4, 6, 7};
        Node root = null;
        for (int data : ints) {
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}
