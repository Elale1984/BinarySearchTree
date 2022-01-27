package com.algorithms;

public class BinaryTree<T extends Comparable<T>> {


    Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void insert(T data){
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null)
            return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);

        return node;
    }

    public int findInTree(T data){
        int elements = 0;
        Node<T> curr = root;

        while (curr != null){

            if(data.compareTo(curr.data) == 0){
                return elements;
            }
            else if(data.compareTo(curr.data) > 0){
                elements++;
                curr = curr.right;
            }
            else if (data.compareTo(curr.data) < 0){
                elements++;
                curr = curr.left;
            }
        }
        return -1;
    }

    public void removeFromTree(T data){

    }

    public void inOrderTraversal(Node<T> node){
        if(node != null){
            inOrderTraversal(node.left);
            node.printData();
            inOrderTraversal(node.right);
        }
    }
}
