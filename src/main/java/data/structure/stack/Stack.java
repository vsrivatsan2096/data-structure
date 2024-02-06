package data.structure.stack;

import data.structure.list.SinglyLinkedList;

public class Stack<T> {
    private final SinglyLinkedList<T> singlyLinkedList;

    public Stack() {
        this.singlyLinkedList = new SinglyLinkedList<>();
    }

    public void push(T data) {
        singlyLinkedList.insert(data, singlyLinkedList.getSize());
    }

    public T pop() {
        return singlyLinkedList.delete(singlyLinkedList.getSize() - 1);
    }

    @Override
    public String toString() {
        return singlyLinkedList.toString();
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        stringStack.push("Fourth");
        stringStack.push("Fifth");

        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

        System.out.println(stringStack);
    }
}
