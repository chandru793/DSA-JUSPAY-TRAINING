import java.util.*;

public class ll {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ll insert(ll list, int data) {
        Node curr = new Node(data);

        if (list.head == null) {
            list.head = curr;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = curr;
        }

        return list;
    }
    
    public static void printll(ll list) {
        Node curr = list.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("--------");
    }
    
    public static void main(String[] args) {
        ll list = new ll();

        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);

        printll(list);
    }
}