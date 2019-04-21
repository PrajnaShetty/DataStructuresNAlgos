package datastructures.queues;

/**
 * Created by prajnashetty on 1/23/19.
 */
public class QueueUsingArray<E> {

    private Object[] elements;
    private int front, rear;
    private int size;
    private int capacity;

    QueueUsingArray(int c) {
        capacity = c;
        front = size = 0;
        rear = capacity - 1;
        elements = new Object[capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(E ele) {
        if (isFull())
            return;

        rear = (rear + 1) % capacity;
        elements[rear] = ele;
        size++;
    }

    E dequeue() {
        if (isEmpty())
            return null;

        E ele = (E) elements[front];
        front = (front + 1) % capacity;
        size--;

        return ele;
    }

    E getFront() {
        if (isEmpty())
            return null;

        return (E)elements[front];
    }


    E getRear() {
        if (isEmpty())
            return null;

        return (E)elements[rear];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int s = 0;
        for (int i = front; i <= rear; i++) {
            s++;
            if (s == size) {
                sb.append(elements[i]);
            } else {
                sb.append(elements[i] + ", ");
            }

        }
        sb.append("]");
        return  sb.toString();
    }


    public static void main(String[] args) {
        QueueUsingArray<Integer> queue = new QueueUsingArray<>(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        System.out.println(queue.dequeue());
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        System.out.println(queue);

    }
}
