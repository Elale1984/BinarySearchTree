package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        BinaryTree<String> binaryTree = new BinaryTree();
        Scanner read = new Scanner(new File("input.txt"));


        String word;

        while (read.hasNext()){
            System.out.println(read.next().replaceAll("\\p{Punct}", ""));

        }

    }
}
