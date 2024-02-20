package data.structure.tree;

import data.holder.node.BinaryTreeNode;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    protected BinaryTreeNode<T> rootNode;

    public void insert(T data) {
        if (rootNode == null) {
            rootNode = new BinaryTreeNode<>(data);

            return;
        }

        insert(rootNode, data);
    }

    public List<T> inOrderTraversal() { return super.inOrderTraversal(rootNode); }

    public List<T> preOrderTraversal() { return super.preOrderTraversal(rootNode); }

    public List<T> postOrderTraversal() { return super.postOrderTraversal(rootNode); }

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
