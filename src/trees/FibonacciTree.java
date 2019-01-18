package trees;

/**
 * Created by prajnashetty on 1/4/19.
 */
public class FibonacciTree {

    public static void main(String[] args) {
        Node root = buildTree(5);

        Node node = root;
        System.out.println(root);
    }

    private static Node buildTree(int n) {
        if (n < 2) {
            return new Node(n, null, null);
        } else {
            Node node = new Node(n, null, null);
            node.left = buildTree(n - 1);
            node.right =  buildTree(n - 2);
            return node;
        }
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
