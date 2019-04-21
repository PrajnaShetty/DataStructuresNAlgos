package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by prajnashetty on 2/6/19.
 *
 * Traversal
 * Time Complexity: O(n)
 *
 *
 */
public class BinaryTree<E> {
    TreeNode<E> root;

    BinaryTree() {
        root = null;
    }

    BinaryTree(E key) {
        root = new TreeNode<E>(key);
    }

    public void inorder(TreeNode temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    public void preorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                result.add((int)node.data);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }

        System.out.print(result);
    }

    public void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add((int)node.data);
                node = node.right;
            }
        }

        System.out.print(res);
    }

    public void postorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                res.addFirst((int)node.data);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }

        System.out.print(res);
    }

    public void preorder(TreeNode temp) {
        if (temp == null)
            return;
        System.out.print(temp.data + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    public void postorder(TreeNode temp) {
        if (temp == null)
            return;

        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.data + " ");
    }

    public void bfsTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
    }

    public void insertAtLevelOrder(TreeNode temp, int key) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(temp);

        while(!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left == null) {
                temp.left = new TreeNode<Integer>(key);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new TreeNode<Integer>(key);
                break;
            } else {
                queue.add(temp.right);
            }

        }
    }

    int findMax(TreeNode node ) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = (int)node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        return Math.max(res, Math.max(lres, rres));
    }

    int findMin(TreeNode node ) {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = (int)node.data;
        int lres = findMin(node.left);
        int rres = findMin(node.right);

        return Math.min(res, Math.min(lres, rres));
    }

    int getTreeHeight(TreeNode node){

        if (node == null)
            return 0;
        return 1 + Math.max(getTreeHeight(node.left), getTreeHeight(node.right));

    }



    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new TreeNode<>(10);

        tree.root.left = new TreeNode<Integer>(11);
        tree.root.right = new TreeNode<Integer>(9);

        tree.root.right.left = new TreeNode<Integer>(15);
        tree.root.right.right = new TreeNode<Integer>(8);

        tree.root.left.left = new TreeNode<Integer>(7);


        System.out.print("Inorder traversal before insertion: ");
        tree.inorder(tree.root);

        tree.insertAtLevelOrder(tree.root, 12);

        System.out.print("\nInorder traversal after insertion: ");
        tree.inorder(tree.root);

        System.out.print("\nInorder traversal Iterative: ");
        tree.inorderIterative(tree.root);

        System.out.print("\nPreorder traversal : ");
        tree.preorder(tree.root);

        System.out.print("\nPreorder traversal Iterative: ");
        tree.preorderIterative(tree.root);

        System.out.print("\nPostorder traversal : ");
        tree.postorder(tree.root);

        System.out.print("\nPreorder traversal Iterative: ");
        tree.postorderIterative(tree.root);

        System.out.print("\nBFS traversal : ");
        tree.bfsTraversal(tree.root);

        System.out.print("\nMax : " + tree.findMax(tree.root));
        System.out.print("\nMin : " + tree.findMin(tree.root));

        System.out.print("\nTree Height : " + tree.getTreeHeight(tree.root));

    }


}


class TreeNode<E>{
    E data;
    TreeNode left;
    TreeNode right;

    public TreeNode(E data) {
        this.data = data;
        left = right = null;
    }
}