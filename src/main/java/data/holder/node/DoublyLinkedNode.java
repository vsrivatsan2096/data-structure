package data.holder.node;

public class DoublyLinkedNode<T> extends SinglyLinkedNode<T> {
    private DoublyLinkedNode<T> prev;

    public DoublyLinkedNode(T data) {
        super(data);
    }

    public DoublyLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedNode<T> prev) {
        this.prev = prev;
    }
}
