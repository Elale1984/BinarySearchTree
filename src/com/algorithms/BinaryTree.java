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
    // Get minimum element in binary search tree
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
            // if nodeToBeDeleted have both children
            if (node.left != null && node.right != null) {
                Node<T> temp = node;
                // Finding minimum element from right
                Node<T> minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                node.data = minNodeForRight.data;
                // Deleting minimum node from right now
                node.right = removeFromTree(node.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (node.left != null) {
                node = node.left;
            }
            // if nodeToBeDeleted has only right child
            else if (node.right != null) {
                node = node.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
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

    boolean isBST(Node node)
    {
        if (node == null)
            return true;

        /* False if left is > than node */
        if (node.left != null && node.left.data.compareTo(node.data) > 0)
            return false;

        /* False if right is < than node */
        if (node.right != null && node.right.data.compareTo(node.data) < 0)
            return false;

        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }
}
