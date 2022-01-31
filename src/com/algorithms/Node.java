package com.algorithms;


public class Node<T extends Comparable<T>> {

    T data;
    Node<T> right;
    Node<T> left;
    int counter = 0;

    public Node(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public void printData() {
        System.out.print(this.data + ", ");
    }


}
