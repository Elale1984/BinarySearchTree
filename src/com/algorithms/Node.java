package com.algorithms;

public class Node<T> {

    private T data;
    private Node<T> right;
    private Node<T> left;

    public Node(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public void printData(Node<T> node){
        System.out.println(this.data + " ");
    }
}
