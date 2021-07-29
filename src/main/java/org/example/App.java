package org.example;


import org.example.datastructures.CircularlyLinkedList;
import org.w3c.dom.Node;

/**
 * Hello world!
 */


public class App {
    public static void main(String[] args) {
        System.out.println(electStudent(4,2));
    }

    static int electStudent(int numberOfStudents, int songLength){
        CircularlyLinkedList circularlyLinkedList = new CircularlyLinkedList();
        CircularlyLinkedList.Node currentNode;


        if(numberOfStudents == 1){
            return  1;
        }

        for(int i = 1; i <= numberOfStudents; i++){
            circularlyLinkedList.addNode(i);
        }

        currentNode = circularlyLinkedList.getHead();

        while(circularlyLinkedList.getSize() > 1){
            for(int i = 0; i < songLength; i++){
                currentNode = currentNode.next;
            }
            circularlyLinkedList.removeNode(currentNode);
        }

        return  circularlyLinkedList.getHead().getVal();
    }

    static String encodeFromFirst(String s) {

        String encodedString = String.valueOf(s.charAt(0));


        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0)) {

                String compareString = s.substring(0, i);
                System.out.println(compareString);
                if ( i * 2 <= s.length() && s.substring(i, i * 2).equals(compareString)) {
                    encodedString += "*";
                    i = i * 2 - 1;
                } else {
                    encodedString += s.charAt(i);
                }
            } else {
                encodedString += s.charAt(i);
            }
        }
        System.out.println("here");
        return encodedString;
    }
}


