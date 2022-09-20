package com.example.btree;

public class BinaryTreeImpl {
    private Node root;

    public Node find(int key) {
        Node current = root;
        if (current == null) {
            System.out.println("Binary Tree is Empty!");
            return null;
        }

        while (current.getiData() != key) {
            if (key < current.getiData())
                current = current.getLeftChild();
            else
                current = current.getRightChild();

            if (current == null) {
                System.out.println("Element not found.");
                return null;
            }
        }
        return current;
    }

    public void insertValue(int iData, String dData) {
        Node newNode = new Node(iData, dData);
        insertValue(newNode);
    }

    public void insertValue(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (newNode.getiData() < current.getiData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteValue(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.getiData() != key) {
            parent = current;
            if (key < current.getiData()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null)
                return false;
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
        } else if (current.getRightChild() == null) {
            if (current == root)
                root = current.getLeftChild();
            else if (isLeftChild)
                parent.setLeftChild(current.getLeftChild());
            else
                parent.setRightChild(current.getRightChild());
        } else {
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.setLeftChild(successor);
            else
                parent.setRightChild(successor);
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    public void traverse(TraverseType type) {
        switch (type) {
            case PREORDER:
                System.out.println("Preorder traversal:");
                preOrder(root);
                break;
            case INORDER:
                System.out.println("InOrder traversal:");
                inOrder(root);
                break;
            case POSTORDER:
                System.out.println("PostOrder traversal:");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getiData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getiData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getiData() + " ");
        }
    }
}
