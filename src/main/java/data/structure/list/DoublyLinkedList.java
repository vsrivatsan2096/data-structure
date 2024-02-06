package data.structure.list;

import data.holder.node.DoublyLinkedNode;
import data.holder.node.SinglyLinkedNode;

public class DoublyLinkedList<T> extends LinkedList<T, DoublyLinkedNode<T>> {
    @Override
    public void insert(T data, int index) {
        int size = getSize();

        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(data);

        if (size == 0) {
            setHead(node);
            setTail(node);
        } else if(index == 0) {
            node.setNext(getHead());
            getHead().setPrev(node);

            setHead(node);
        } else if (index >= size) {
            DoublyLinkedNode<T> temp = getTail();

            temp.setNext(node);
            node.setPrev(temp);

            setTail(node);
        } else {
            DoublyLinkedNode<T> temp = getHead();

            int i = 1;
            while (i < index) {
                temp = (DoublyLinkedNode<T>) temp.getNext();

                i ++;
            }

            node.setNext(temp.getNext());
            node.setPrev(temp);

            ((DoublyLinkedNode<T>)temp.getNext()).setPrev(node);
            temp.setNext(node);
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
        } else if (index >= size) {
            data = getTail().getData();

            setTail(getTail().getPrev());

            getTail().setNext(null);
        } else if (index == 0) {
            data = getHead().getData();

            setHead((DoublyLinkedNode<T>) getHead().getNext());

            getHead().setPrev(null);
        } else {
            DoublyLinkedNode<T> temp = getHead();

            int i = 1;
            while (i < index) {
                temp = (DoublyLinkedNode<T>) temp.getNext();

                i ++;
            }

            data = temp.getNext().getData();

            if (temp.getNext() == getTail()) {
                setTail(temp);
            } else {
                ((DoublyLinkedNode<T>)temp.getNext().getNext()).setPrev(temp);
            }


            temp.setNext(temp.getNext().getNext());
        }

        incrementSize(-1);

        return data;
    }

    @Override
    public String toString() {
        int i = 0;

        String[] forwardStringArray = new String[getSize()];

        SinglyLinkedNode<T> singlyLinkedNode = getHead();
        while (singlyLinkedNode != null) {
            forwardStringArray[i ++] = singlyLinkedNode.getData().toString();

            singlyLinkedNode = singlyLinkedNode.getNext();
        }

        String[] reverseStringArray = new String[getSize()];

        i = 0;
        DoublyLinkedNode<T> doublyLinkedNode = getTail();
        while (doublyLinkedNode != null) {
            reverseStringArray[i ++] = doublyLinkedNode.getData().toString();

            doublyLinkedNode = doublyLinkedNode.getPrev();
        }

        return String.join(" -> ", forwardStringArray)
                + "\n"
                + String.join(" -> ", reverseStringArray);
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.insert("First", 0);
        doublyLinkedList.insert("Third", 1);
        doublyLinkedList.insert("Second", 1);
        doublyLinkedList.insert("Fourth", 3);
        doublyLinkedList.insert("Fifth", 5);

        System.out.println(doublyLinkedList);

        doublyLinkedList.delete(0);
        doublyLinkedList.delete(2);
        doublyLinkedList.delete(2);

        System.out.println(doublyLinkedList);
    }
}
