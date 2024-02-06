package data.structure.queue;

import data.structure.list.DoublyLinkedList;

public class DoubleEndedQueue<T> {
    private final DoublyLinkedList<T> doublyLinkedList;

    public DoubleEndedQueue() {
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public void enqueueFirst(T data) {
        doublyLinkedList.insert(data, 0);
    }

    public T dequeueFirst() {
        return doublyLinkedList.delete(0);
    }

    public void enqueueLast(T data) {
        doublyLinkedList.insert(data, doublyLinkedList.getSize());
    }

    public T dequeueLast() {
        return doublyLinkedList.delete(doublyLinkedList.getSize());
    }

    @Override
    public String toString() {
        return doublyLinkedList.toString();
    }

    public static void main(String[] args) {
        DoubleEndedQueue<String>  doubleEndedQueue = new DoubleEndedQueue<>();

        doubleEndedQueue.enqueueLast("LFirst");
        doubleEndedQueue.enqueueLast("LSecond");

        doubleEndedQueue.enqueueFirst("FSecond");
        doubleEndedQueue.enqueueFirst("FFirst");

        System.out.println(doubleEndedQueue);

        System.out.println(doubleEndedQueue.dequeueFirst());
        System.out.println(doubleEndedQueue.dequeueLast());

        System.out.println(doubleEndedQueue);
    }
}
