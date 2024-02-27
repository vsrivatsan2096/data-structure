package data.structure.tree;

import data.holder.node.BinaryTreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class BinaryTree<T> {

    protected BinaryTreeNode<T> rootNode;

    private List<T> inOrderTraversal(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return new ArrayList<>();
        }

        List<T> left = inOrderTraversal(rootNode.getLeft());

        List<T> root = new ArrayList<>(Collections.singletonList(rootNode.getData()));

        List<T> right = inOrderTraversal(rootNode.getRight());

        return Stream.of(left, root, right).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private List<T> preOrderTraversal(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return new ArrayList<>();
        }

        List<T> root = new ArrayList<>(Collections.singletonList(rootNode.getData()));

        List<T> left = inOrderTraversal(rootNode.getLeft());

        List<T> right = inOrderTraversal(rootNode.getRight());

        return Stream.of(root, left, right).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private List<T> postOrderTraversal(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return new ArrayList<>();
        }

        List<T> left = inOrderTraversal(rootNode.getLeft());

        List<T> right = inOrderTraversal(rootNode.getRight());

        List<T> root = new ArrayList<>(Collections.singletonList(rootNode.getData()));

        return Stream.of(left, right, root).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<T> inOrderTraversal() { return inOrderTraversal(rootNode); }

    public List<T> preOrderTraversal() { return preOrderTraversal(rootNode); }

    public List<T> postOrderTraversal() { return postOrderTraversal(rootNode); }
}