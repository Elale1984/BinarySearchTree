package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        BinaryTree<String> binaryTree = new BinaryTree<>();
        Scanner read = new Scanner(new File("input.txt"));

        while (read.hasNext()){
            String word = read.next().toLowerCase(Locale.ROOT).replaceAll("\\p{Punct}", "");
            System.out.println(word);
            binaryTree.insert(word);

        }
        read.close();

        System.out.println("\n in Order Traversal");
        binaryTree.inOrderTraversal(binaryTree.root);

        binaryTree.preOrderTraversal(binaryTree.root);
        searchForWords(binaryTree, reader);
        removeFromWords(binaryTree, reader);

    }

    private static void removeFromWords(BinaryTree<String> binaryTree, Scanner reader) {
        boolean endAll = false;

        do {
            System.out.print("\n Enter a word to remove or -1 to quit: ");
            String word = reader.next();

            if(word.equals("-1")){
                endAll = true;
            }
            else {

                System.out.println("Deleting " + word);

                binaryTree.removeFromTree(word);

                System.out.println();
                binaryTree.inOrderTraversal(binaryTree.root);
                System.out.println("Still BST = " + binaryTree.isBST(binaryTree.root));
            }

        } while (!endAll);


    }

    public static void searchForWords(BinaryTree<String> binaryTree, Scanner reader){
        boolean endAll = false;
        do {
            System.out.print("\n Enter a word to search for or -1 to quit: ");
            String word = reader.next();

            if(Objects.equals(word, "-1")){
                endAll = true;
            }
            else {
                System.out.println("The number of elements till the word was found was " + binaryTree.findInTree(word));
                System.out.println();
            }

        } while (!endAll);


    }


}
