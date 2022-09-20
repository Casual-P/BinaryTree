package com.example.btree.bootstrap;

import com.example.btree.BinaryTreeImpl;

public class TreeBootstrap {

    private final BinaryTreeImpl binaryTree;

    public TreeBootstrap(BinaryTreeImpl binaryTree) {
        this.binaryTree = binaryTree;
    }

    public void insert10Elements() {
        binaryTree.insertValue(25, "qwerty_");
        binaryTree.insertValue(10, "qwerty");
        binaryTree.insertValue(30, "qwerty");
        binaryTree.insertValue(50, "qwerty");
        binaryTree.insertValue(20, "qwerty");
        binaryTree.insertValue(70, "qwerty");
        binaryTree.insertValue(15, "qwerty");
        binaryTree.insertValue(45, "qwerty");
        binaryTree.insertValue(90, "qwerty");
        binaryTree.insertValue(100, "qwerty");
    }
}
