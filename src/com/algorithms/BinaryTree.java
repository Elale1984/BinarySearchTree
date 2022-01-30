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



    public Node<T> removeFromTree(T data){
        Node<T> node = root;
        Node<T> prev = node;

        if(node == null)
            return null;

        else {

            while (node != null){

                 if(data.compareTo(node.data) > 0){
                     prev = node;
                     node = node.right;
                 }

                else if(data.compareTo(node.data) < 0){
                    prev = node;
                    node = node.left;
                }
                else if (data.compareTo(node.data) == 0){

                    removeTheNodeAndRestructureTree(prev, node);
                    return node;
                }
            }
        }
        return null;
    }

    private void removeTheNodeAndRestructureTree(Node<T> prev, Node<T> node) {

        if(node.left == null && node.right == null) {
            if(prev.right == node) {
                prev.right = null;
            }
            else {
                prev.left = null;
            }
        }
        else if(node.left != null && node.right != null) {
            node.data = node.right.data;
            prev.right = node.right;
        }
        else {
            if(prev.right == node) {
                if(node.right != null)
                    prev.right = node.right;
                else
                    prev.right = node.left;
            }
            else {
                if(node.right != null)
                    prev.left = node.right;
                else
                    prev.left = node.left;
            }
        }
    }


    public void inOrderTraversal(Node<T> node){
        if(node != null){
            inOrderTraversal(node.left);
            node.printData();
            inOrderTraversal(node.right);
        }
    }
}
