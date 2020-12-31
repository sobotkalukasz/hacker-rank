package pl.lsobotka.hacker.rank.daysofcode;

/*
 * https://www.hackerrank.com/challenges/30-linked-list-deletion/problem
 * */
public class MoreLinkedList {

    public static NodeLinked removeDuplicates(NodeLinked head) {
        if (head != null) {
            while (head.next != null && head.data == head.next.data) {
                head = head.next;
            }
            head.next = removeDuplicates(head.next);
        }
        return head;
    }

    public static NodeLinked insert(NodeLinked head, int data) {
        NodeLinked p = new NodeLinked(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            NodeLinked start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(NodeLinked head) {
        NodeLinked start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        NodeLinked head = null;

        int[] ints = new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4};
        for (int anInt : ints) {
            head = insert(head, anInt);
        }

        head = removeDuplicates(head);
        display(head);

    }
}

class NodeLinked {
    int data;
    NodeLinked next;

    NodeLinked(int d) {
        data = d;
        next = null;
    }

}
