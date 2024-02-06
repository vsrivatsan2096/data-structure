package data.structure.queue;

import data.structure.list.SinglyLinkedList;

public class Queue<T> {
    protected final SinglyLinkedList<T> singlyLinkedList;

    public Queue() {
        this.singlyLinkedList = new SinglyLinkedList<>();
    }

    public void enqueue(T data) {
        singlyLinkedList.insert(data, singlyLinkedList.getSize());
    }

    public T dequeue() {
        return singlyLinkedList.delete(0);
    }

    @Override
    public String toString() {
        return singlyLinkedList.toString();
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();

        stringQueue.enqueue("First");
        stringQueue.enqueue("Second");
        stringQueue.enqueue("Third");
        stringQueue.enqueue("Fourth");
        stringQueue.enqueue("Fifth");

        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());

        System.out.println(stringQueue);
    }
}
