package elementarydatastructures.queues;

import java.util.Queue;

/**
 * Created by prajnashetty on 1/23/19.
 *
 * Time Complexity:
 * Time complexity of both operations enqueue() and dequeue() is O(1) as we only change few pointers in both operations.
 */
public class QueueUsingLinkedList<E> {

    private QNode<E> front, rear;

    public QueueUsingLinkedList() {
        front = rear = null;
    }

    public void enqueue(E data) {
        QNode<E> temp = new QNode<E>(data);

        if (rear == null) {
            front = rear = temp;
        }

        rear.next = temp;
        rear = temp;
    }

    public QNode dequeue() {
        if (front == null) {
            System.out.println("Empty queue");
            return null;
        }

        QNode<E> temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        QNode node = front;
        while(node != rear && node != null) {
            sb.append(String.valueOf(node.data) + ",");
            node = node.next;
        }
        if (rear != null) {
            sb.append(String.valueOf(rear.data));
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();

        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue);
    }
}


class QNode<E> {
    E data;
    QNode next;

    public QNode(E d) {
        data = d;
        next = null;
    }
}