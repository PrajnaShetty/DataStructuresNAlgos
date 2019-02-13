package elementarydatastructures.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prajnashetty on 1/21/19.
 */
public class StackUsingQueue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

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

        stack.push(30);
        stack.push(40);
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

class Stack<E> {
    private Queue<E> q1 = new LinkedList<>();
    private Queue<E> q2 = new LinkedList<>();

    private int currSize;

    Stack() {
        currSize = 0;
    }

    public void push(E data) {
        q2.add(data);

        while(!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();

        }

        Queue<E> temp = q1;
        q1 = q2;
        q2 = temp;

        currSize++;
    }

    public E pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        currSize--;
        return q1.remove();
    }

    public E peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return q1.peek();
    }

    public int getSize() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}

