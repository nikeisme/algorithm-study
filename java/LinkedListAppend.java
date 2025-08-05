package org.example;

public class LinkedListAppend { // LinkedListAppend 클래스 선언

    static class Node { // Node : 연결리스트의 각 노드
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public LinkedListAppend(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public void printAll() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LinkedListAppend linkedList = new LinkedListAppend(5);
        linkedList.append(12);
        linkedList.append(8);
        linkedList.printAll();
    }
}
