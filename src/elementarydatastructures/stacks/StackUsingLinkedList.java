package elementarydatastructures.stacks;

import java.util.NoSuchElementException;

/**
 * Created by prajnashetty on 1/21/19.
 */
public class StackUsingLinkedList<E> {
    protected Node<E> top;
    protected int size;

    StackUsingLinkedList() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void push(E data) {
        Node<E> node = new Node<>(data);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }

    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        Node node = top;
        top = top.next;
        size--;

        return (E) node.data;
    }

    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        return (E) top.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = top;
        while(node != null) {
            sb.append(String.valueOf(node.data) + " ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();

        System.out.println("isEmpty = "  + stack.isEmpty());
        stack.push(10);
        stack.push(20);

        System.out.println("Stack = " + stack);
        System.out.println("isEmpty = "  + stack.isEmpty());
        System.out.println("Size = " + stack.getSize());

        System.out.println("Peek = " + stack.peek());
        System.out.println("Size = " + stack.getSize());
        System.out.println("Stack = " + stack);

        System.out.println("Pop = " + stack.pop());
        System.out.println("Size = " + stack.getSize());
        System.out.println("Stack = " + stack);

        System.out.println("Pop = " + stack.pop());
        System.out.println("Size = " + stack.getSize());
        System.out.println("Stack = " + stack);

        try {
            stack.pop();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class Node<E> {
    protected E data;
    protected Node<E> next;

    Node(E d) {
        data = d;
        next = null;
    }

    Node(E d, Node<E> n) {
        data = d;
        next = n;
    }
}
