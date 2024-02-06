package data.structure.list;

import data.structure.node.LinkedNode;

public abstract class LinkedList<T, LN extends LinkedNode<T>> implements List<T, LN> {
    private LN head;
    private LN tail;
    private int size = 0;

    protected LN getHead() {
        return head;
    }

    protected void setHead(LN linkedNode) {
        this.head = linkedNode;
    }

    protected LN getTail() {
        return tail;
    }

    protected void setTail(LN linkedNode) {
        this.tail = linkedNode;
    }

    @Override
    public int getSize() {
        return size;
    }

    protected void incrementSize(int increment) {
        this.size += increment;
    }
}
