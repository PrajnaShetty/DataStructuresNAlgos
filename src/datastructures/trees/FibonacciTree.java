package datastructures.trees;

/**
 * Created by prajnashetty on 1/4/19.
 */
public class FibonacciTree {

    public static void main(String[] args) {
        System.out.print("\nFibonacci Tree - Iterative : ");
        Node root = buildTreeIterative(6);
        inorder(root);
    }

    public static void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }



    private static Node buildTreeIterative(int n) {
        Node[] nodeArray = new Node[n + 1];

        nodeArray[0] = new Node(0, null, null);
        nodeArray[1] = new Node(1, null, null);

        for (int i = 2; i <= n ; i++) {
            int value = nodeArray[i - 1].val + nodeArray[i - 2].val;
            Node node = new Node(value, null, null);
            node.left = nodeArray[i - 1];
            node.right = nodeArray[i - 2];
            nodeArray[i] = node;
        }

        return nodeArray[n];
    }
}


class Node {
    int val;
    Node left;
    Node right;

    Node(int x, Node l, Node r) {
        val = x;
        left = l;
        right = r;
    }
}
