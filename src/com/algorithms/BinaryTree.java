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

    public void removeFromTree(T data) {
        if(findInTree(data) != -1)
            removeFromTree(root, data);
        else
            System.out.println(data + " Not found in tree");
    }
    public Node<T> minimumElement(Node<T> root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    public Node<T> removeFromTree(Node<T> node, T data) {
        if (node == null)
            return null;
        if (node.data.compareTo(data) > 0) {
            node.left = removeFromTree(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = removeFromTree(node.right, data);

        } else {
            if (node.left != null && node.right != null) {
                Node<T> minNodeForRight = minimumElement(node.right);
                node.data = minNodeForRight.data;
                node.right = removeFromTree(node.right, minNodeForRight.data);

            }
            else if (node.left != null) {
                node = node.left;
            }
            else if (node.right != null) {
                node = node.right;
            }
            else
                node = null;
        }
        return node;
    }




    public void preOrderTraversal(Node<T> node){
        if(node != null){
            node.printData();
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void inOrderTraversal(Node<T> node){
        if(node != null){
            inOrderTraversal(node.left);
            node.printData();
            inOrderTraversal(node.right);
        }
    }

    boolean isBST(Node<T> node)
    {
        if (node == null)
            return true;

        if (node.left != null && node.left.data.compareTo(node.data) > 0)
            return false;

        if (node.right != null && node.right.data.compareTo(node.data) < 0)
            return false;

        return isBST(node.left) && isBST(node.right);
    }
}
