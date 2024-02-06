package data.holder.node;

public abstract class LinkedNode<T> implements Node<T> {
    protected T data;

    protected LinkedNode<T> next;
    public LinkedNode(T data) {
        this.data = data;
    }
}
