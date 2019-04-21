package datastructures.stacks;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/21/19.
 */
public class StackUsingArray<E> {

    private int top = 0;
    private static final int DEFAULT_CAPACITY = 3;
    private Object[] elements;

    public StackUsingArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(E ele) {
        if (top == elements.length) {
            ensureCapacity();
        }
        elements[top++] = ele;

    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        E ele = (E)elements[--top];
        elements[top] = null;
        return ele;
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public int getSize() {
        return top;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                sb.append(elements[i].toString());
                if (i < top - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        StackUsingArray<Integer> integerStack = new StackUsingArray<>();
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);
        integerStack.push(40);

        System.out.println(integerStack);
        System.out.println("Size = " + integerStack.getSize());

        System.out.println( integerStack.pop() );
        System.out.println( integerStack.pop() );
        System.out.println( integerStack.pop() );
        System.out.println( integerStack.pop() );
        System.out.println( integerStack.pop() );
        System.out.println( integerStack );
        System.out.println("is Empty = " + integerStack.isEmpty());
        System.out.println("Size = " + integerStack.getSize());
        System.out.println( integerStack.pop() );
        System.out.println( integerStack );
        System.out.println("is Empty = " + integerStack.isEmpty());

    }

}
