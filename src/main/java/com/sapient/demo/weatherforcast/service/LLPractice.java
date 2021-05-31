package com.sapient.demo.weatherforcast.service;

public class LLPractice {

    Node head;

    public static void main(String[] args) {

        LLPractice ll = new LLPractice();

        ll.head = new Node(10);

        Node node1 = new Node(62);

        Node node2 = new Node(37);

        ll.head.next = node1;

        node1.next = node2;

        Node n = ll.head;
        while (n != null) {
            System.out.print(n.data +"->");
            n = n.next;
        }

    }
/*  4->3->2->1->null */
    public void reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;





    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
