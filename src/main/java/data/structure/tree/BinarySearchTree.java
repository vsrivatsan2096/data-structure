package data.structure.tree;

import data.holder.node.BinaryTreeNode;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void insert(T data) {
        if (rootNode == null) {
            rootNode = new BinaryTreeNode<>(data);

            return;
        }

        insert(rootNode, data);
    }

    // Only code is implemented not yet tested
    public void delete(T data) {
        BinaryTreeNode<T> parentNode = getParent(rootNode, data);

        if (parentNode == null) return;

        BinaryTreeNode<T> tempNode = parentNode.getLeft() != null && parentNode.getLeft().getData() == data ?
                parentNode.getLeft() : parentNode.getRight();

        if (tempNode.getLeft() != null && tempNode.getRight() != null) {
            BinaryTreeNode<T> inorderSuccessorParent = getInorderSuccessorParent(tempNode.getRight());

            // It does not have leaf nodes
            if (parentNode.getLeft() == tempNode) {
                parentNode.setLeft(inorderSuccessorParent.getLeft());
            } else {
                parentNode.setRight(inorderSuccessorParent.getLeft());
            }

            inorderSuccessorParent.setLeft(null);
        } else if (tempNode.getLeft() != null || tempNode.getRight() != null) {
            if (parentNode.getLeft() == tempNode) {
                if (tempNode.getLeft() != null) {
                    parentNode.setLeft(tempNode.getLeft());
                } else {
                    parentNode.setLeft(tempNode.getRight());
                }
            } else {
                if (tempNode.getLeft() != null) {
                    parentNode.setRight(tempNode.getLeft());
                } else {
                    parentNode.setRight(tempNode.getRight());
                }
            }
        } else {
            // It does not have leaf nodes
            if (parentNode.getLeft() == tempNode) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }
    }

    private BinaryTreeNode<T> getInorderSuccessorParent(BinaryTreeNode<T> tempNode) {
          while (tempNode.getLeft().getLeft() != null) {
              tempNode = tempNode.getLeft();
          }

          return tempNode;
    }

    private void insert(BinaryTreeNode<T> rootNode, T data) {
        if (data.compareTo(rootNode.getData()) > 0) {
            if (rootNode.getRight() == null) {
                rootNode.setRight(new BinaryTreeNode<>(data));
            } else {
                insert(rootNode.getRight(), data);
            }
        } else {
            if (rootNode.getLeft() == null) {
                rootNode.setLeft(new BinaryTreeNode<>(data));
            } else {
                insert(rootNode.getLeft(), data);
            }
        }
    }

    private BinaryTreeNode<T> getParent(BinaryTreeNode<T> tempNode, T data) {
        if (tempNode == null) return null;

        if (tempNode.getLeft() == null || tempNode.getRight() == null) return null;

        if (tempNode.getLeft().getData() == data || tempNode.getRight().getData() == data) {
            return tempNode;
        } else if (data.compareTo(tempNode.getData()) > 0) {
            return getParent(tempNode.getRight(), data);
        } else {
            return getParent(tempNode.getLeft(), data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);

        System.out.println("Inorder: " + binarySearchTree.inOrderTraversal());
        System.out.println("Preorder: " + binarySearchTree.preOrderTraversal());
        System.out.println("Postorder: " + binarySearchTree.postOrderTraversal());
    }
}
