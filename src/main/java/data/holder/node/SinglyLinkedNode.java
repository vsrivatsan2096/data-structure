package data.holder.node;

public class SinglyLinkedNode<T> extends LinkedNode<T> {
    SinglyLinkedNode<T> next;

    @Override
    public T getData() {
        return data;
    }

    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    }

    public SinglyLinkedNode(T data) {
        super(data);
    }
}
