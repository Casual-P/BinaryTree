package com.example.btree;

class Node {
    private final int iData;
    private final String dData;
    private Node leftChild;
    private Node rightChild;


    public Node(int iData, String dData) {
        this.iData = iData;
        this.dData = dData;
    }


    @Override
    public String toString() {
        return "iData = " + iData + ", dData = " + dData;
    }

    public int getiData() {
        return iData;
    }

    public String getdData() {
        return dData;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
