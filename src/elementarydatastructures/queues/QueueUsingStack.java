package elementarydatastructures.queues;

import java.util.Stack;

/**
 * Created by prajnashetty on 1/23/19.
 */
public class QueueUsingStack<E> {
    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    void enqueue(E data) {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    E dequeue() {
        if (stack1.empty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return stack1.pop();
        }
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);


    }
}


