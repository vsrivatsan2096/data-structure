package data.structure.list;

import data.structure.node.Node;

public interface List<T, N extends Node<T>> {
    int getSize();

    void insert(T data, int index);

    void delete(int index);
}
