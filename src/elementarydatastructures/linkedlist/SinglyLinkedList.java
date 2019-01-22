package elementarydatastructures.linkedlist;

/**
 * Created by prajnashetty on 1/19/19.
 */
public class SinglyLinkedList<E> {
    Node<E> head;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);

        list.head = first;
        first.next = second;
        second.next = third;

        list.printList();
        list.push(0);
        list.insertAfter(second, 99);
        list.append(4);
        list.printList();
    }

    public void printList() {
        Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /* Inserts a new Node at front of the list. */
    public void push(E newData) {
        Node<E> newNode = new Node<>(newData);
        newNode.next = head;
        head = newNode;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prevNode, E newData) {
        if (prevNode == null) {
            System.out.println("Error!!");
            return;
        }
        Node<E> newNode  = new Node<>(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    /* Appends a new node at the end. */
    public void append(E newData) {
        Node<E> newNode = new Node<>(newData);

        if (head == null) {
            head = newNode;
            return;
        }

        Node node = head;
        while(node.next != null) {
            node = node .next;

        }
        node.next = newNode;
    }


}

class Node<E> {
    E data;
    Node next;

    Node(E d) {
        data = d;
        next = null;
    }
}