package data.structure.list;

import data.holder.node.Node;

public interface List<T, N extends Node<T>> {
    int getSize();

    void insert(T data, int index);

    T delete(int index);
}
