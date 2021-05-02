package com.booleans.calendar.FRQ.Praveen;

import java.util.ArrayList;

public class LinkedList{

    public Node head;
    public ArrayList<Node> nodes;

    public LinkedList(int[] vals){
        this.head = new Node(vals[0]);
        //System.out.println(head.value);
        this.nodes = new ArrayList<Node>();
        nodes.add(head);

        for (int i = 1; i < vals.length; i++){
            int val = vals[i];
            nodes.add(new Node(val));
        }
        for (int i = 0; i < nodes.size() - 1; i++){
            nodes.get(i).next = nodes.get(i+1);
        }

    }

    public void addHead(int val){
        int[] vals = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++){
            vals[i] = nodes.get(i).value;
        }
        this.head = new Node(val);
        //System.out.println(head.value);
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(head);


        for (int i = 0; i < vals.length; i++){

            nodes.add(new Node(vals[i]));
        }
        for (int i = 0; i < nodes.size() - 1; i++){
            nodes.get(i).next = nodes.get(i+1);
        }

    }

    public void addTail(int val){
        nodes.add(new Node(val));
        nodes.get(nodes.size()-1).next = nodes.get(nodes.size());
    }

    // create an object of Node class
    // represent the head of the linked list


    // static inner class
    static class Node {
        int value;

        // connect each node to next node
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
        public Node next(){
            if (next != null) return next;
            return null;

        }
    }



    public ArrayList<Integer> traverse(){
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Node current = head;
        while (current != null) {
            vals.add(current.value);
            current = current.next;
        }
        return vals;
    }
    public String toString(){
        String result = "";
        for (int val : traverse()){
            result = result + val + ", ";
        }
        return result;
    }

    public static void main(String[] args) {

        // create an object of LinkedList
        LinkedList linkedList = new LinkedList(new int[] {1,2,3});


        System.out.println(linkedList.traverse());

        //System.out.println(linkedList.head.value);
        //System.out.println(linkedList.head.next.value);
        linkedList.addHead(6);
        System.out.println(linkedList.traverse());

    }
}
