package org.example.datastructures;


import java.util.Optional;

public class CircularlyLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public class Node {
        public Node next = null;
        public Node before = null;
        int val;

        Node(Node next, int val){
            this.next = next;
            this.val = val;
        }

        Node(int val){
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public void addNode(int val){

        if(Optional.ofNullable(head).isEmpty()){
            head = new Node(val);
        } else if(Optional.ofNullable(tail).isEmpty()){
            tail = new Node(val);
            head.setNext(tail);
            head.setBefore(tail);
            tail.setNext(head);
            tail.setBefore(head);

        } else {
            Node newNode = new Node(val);
            tail.next = newNode;
            newNode.before = tail;
            tail = newNode;
            tail.next = head;
            head.before = tail;
        }

        size++;
    }

    public int removeNode(int index){

        if(index >= this.size){
            System.out.println("illegal operation");
            return -1;
        }

        if(index == 0){
            if(this.size == 1){
                head = null;
            } else if (this.size == 2){
                head = tail;
                tail.before = null;
                tail.next = null;
            }

            head.next.before = tail;
            tail.next = head.next;
            head = head.next;

            this.size--;
            return 1;
        }

        Node currentNode = head;

        for(int i = 1; i <= index; i++){
            currentNode = currentNode.next;
        }

        currentNode.before.next = currentNode.next;
        currentNode.next.before = currentNode.before;
        this.size--;
        return 1;
    }

    public void removeNode(Node node){
        node.next.before = node.before;
        node.before.next = node.next;
        this.size--; 
    }


    public void printNodes(){
        Node currentNode = head;
        for(int i = 0; i < this.size; i++){
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }


    }

}
