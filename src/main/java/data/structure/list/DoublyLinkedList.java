package data.structure.list;

import data.structure.node.DoublyLinkedNode;
import data.structure.node.SinglyLinkedNode;

public class DoublyLinkedList<T> extends LinkedList<T, DoublyLinkedNode<T>> {
    @Override
    public void insert(T data, int index) {

    }

    @Override
    public void delete(int index) {

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

        DoublyLinkedNode<T> doublyLinkedNode = getTail();
        while (doublyLinkedNode != null) {
            reverseStringArray[i ++] = doublyLinkedNode.getData().toString();

            doublyLinkedNode = doublyLinkedNode.getPrev();
        }

        return String.join(" -> ", forwardStringArray)
                + "\n"
                + String.join(" -> ", reverseStringArray);
    }
}
