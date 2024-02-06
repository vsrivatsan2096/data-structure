package data.structure.list;

import data.holder.node.SinglyLinkedNode;

public class SinglyLinkedList<T> extends LinkedList<T, SinglyLinkedNode<T>> {

    @Override
    public void insert(T data, int index) {
        SinglyLinkedNode<T> singlyLinkedNode = new SinglyLinkedNode<>(data);

        int size = getSize();

        if (size == 0) {
            setHead(singlyLinkedNode);
            setTail(singlyLinkedNode);
        } else if (index >= size) {
            SinglyLinkedNode<T> tail = getTail();

            tail.setNext(singlyLinkedNode);

            setTail(singlyLinkedNode);
        } else {
            SinglyLinkedNode<T> temp = getHead();
            int i = 1;

            while (i < index) {
                temp = temp.getNext();

                i ++;
            }

            singlyLinkedNode.setNext(temp.getNext());
            temp.setNext(singlyLinkedNode);
        }

        incrementSize(1);
    }

    @Override
    public T delete(int index) {
        T data = null;

        int size = getSize();

        if (size == 1) {
            data = getHead().getData();

            setHead(null);
            setTail(null);
        } else if (index == 0) {
            SinglyLinkedNode<T> temp = getHead();

            setHead(temp.getNext());

            data = temp.getData();
        } else {
            int i = 1;

            SinglyLinkedNode<T> temp = getHead();
            while (i < index) {
                temp = temp.getNext();

                i ++;
            }

            data = temp.getNext().getData();

            if (temp.getNext() == getTail()) {
                setTail(temp);
            }

            temp.setNext(temp.getNext().getNext());
        }

        incrementSize(-1);

        return data;
    }

    @Override
    public String toString() {
        int i = 0;
        String[] stringArray = new String[getSize()];

        SinglyLinkedNode<T> singlyLinkedNode = getHead();
        while (singlyLinkedNode != null) {
            stringArray[i ++] = singlyLinkedNode.getData().toString();

            singlyLinkedNode = singlyLinkedNode.getNext();
        }

        return String.join(" -> ", stringArray);
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.insert("First", 0);
        singlyLinkedList.insert("Third", 1);
        singlyLinkedList.insert("Second", 1);
        singlyLinkedList.insert("Fourth", 3);
        singlyLinkedList.insert("Fifth", 5);

        System.out.println(singlyLinkedList);

        singlyLinkedList.delete(0);
        singlyLinkedList.delete(2);
        singlyLinkedList.delete(2);

        System.out.println(singlyLinkedList);
    }
}
