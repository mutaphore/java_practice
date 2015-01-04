import java.util.*;

public class LinkedList {

    public static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        void appendToTail(int data) {
            Node node = new Node(data);
            Node walker = this;

            while (walker.next != null)
                walker = walker.next;

            walker.next = node;
        }
    }

    public static void print(Node head) {

        for (Node walker = head; walker != null; walker = walker.next)
            System.out.print(walker.data + " ");
        System.out.println();
    }

    // Remove all duplicates of a linked list
    public static void removeDup(Node head) {
        Node p1, p2;

        for (p1 = head; p1 != null; p1 = p1.next) {

            p2 = p1;
            while (p2 != null) {
                if (p2.next != null && p1.data == p2.next.data) {
                    p2.next = p2.next.next;
                    p2 = p1;
                }
                else
                    p2 = p2.next;
            }
        }
    }

    // Find the Kth to last element of the linked list
    public static Node findKthToLast(Node head, int k) {
        Node cur = head, prev = head, walker;
        int counter = 0;

        for (int i = 0; i < k; i++)
            cur = cur.next;

        for (walker = head; cur != null;
         cur = cur.next, walker = walker.next) {
            if (counter == k - 1)
                prev = walker.next;
            counter = (counter + 1) % k;
        }

        for (int i = 0; i < counter; i++)
            prev = prev.next;

        return prev;
    }

    // Given only the mid node of a linked list, delete the element
    public static void deleteMid(Node mid) {
        Node cur = mid, post = mid.next;

        while (post.next != null) {
            cur.data = post.data;
            cur = post;
            post = post.next;
        }

        cur.data = post.data;
        cur.next = null;
    }

    // Partition a linked list around x
    public static Node partition(Node head, int x) {
        Node first = null, last = null, temp, walker = head;

        while (walker != null) {
            temp = walker;
            walker = walker.next;

            if (first == null)
                first = last = temp;
            else if (temp.data < x) {
                temp.next = first;
                first = temp;
            }
            else {
                temp.next = null;
                last.next = temp;
                last = temp;
            }
        }

        return first;
    }

    // Add numbers represented by linked list. E.g. 123 = 3->2->1
    public static Node addNums(Node head1, Node head2) {
        int num1 = 0, num2 = 0, digit, sum;
        Node ret = null, node, end = null;

        digit = 1;
        while (head1 != null) {
            num1 = num1 + (head1.data * digit);
            digit *= 10;
            head1 = head1.next;
        }

        digit = 1;
        while (head2 != null) {
            num2 = num2 + (head2.data * digit);
            digit *= 10;
            head2 = head2.next;
        }

        sum = num1 + num2;
        while (sum != 0) {
            digit = sum % 10;
            sum /= 10;
            node = new Node(digit);
            if (ret == null)
                ret = end = node;
            else
                end = end.next = node;
        }

        return ret;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(7);
        head.appendToTail(5);
        head.appendToTail(9);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(8);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(6);
        head.appendToTail(3);
        head.appendToTail(1);

        System.out.println("Original: ");
        print(head);
        System.out.println("Dups removed: ");
        removeDup(head);
        print(head);

        Node kth = findKthToLast(head, 5);
        System.out.println("kth to last element: " + kth.data);

        Node walker = head, mid;
        int count = 0;
        for (mid = head; walker != null; walker = walker.next, count++) {
            if (count == 2) {
                mid = mid.next;
                count = 0;
            }
        }
        System.out.println("Mid element is " + mid.data);
        System.out.println("After deleteMid:");
        deleteMid(mid);
        print(head);

        System.out.println("After partition: ");
        head = partition(head, 8);
        print(head);

        Node head1 = new Node(7);
        head1.appendToTail(1);
        head1.appendToTail(6);
        Node head2 = new Node(5);
        head2.appendToTail(9);
        head2.appendToTail(2);
        System.out.println("617 + 295: ");
        Node sum = addNums(head1, head2);
        print(sum);
    }
}
