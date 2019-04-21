package datastructures.trees;

/**
 * Created by prajnashetty on 3/3/19.
 */
public class BinarySearchTree {

    private BSTNode root;
    int index = 0;

    BinarySearchTree() {
        root = null;
    }


    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();

        bsTree.insert(50);
        bsTree.insert(30);
        bsTree.insert(20);
        bsTree.insert(40);
        bsTree.insert(70);
        bsTree.insert(60);
        bsTree.insert(80);

        System.out.println("Sorted order = ");
        bsTree.inorder();

        BSTNode res = bsTree.findLowestCommonAncestor(bsTree.root, 20, 40);
        System.out.println("Lowest common ancestor of 20 & 40 : " + res.value);

        System.out.println();
        System.out.println("Exists = " + (bsTree.search(bsTree.root, 50) != null));
        System.out.println("Exists = " + (bsTree.search(bsTree.root, 90) != null));


        System.out.println();
        System.out.println("Delete 20");
        bsTree.delete(20);
        System.out.println("Inorder traversal of the modified tree after deleting 20");
        bsTree.inorder();

        System.out.println("\nDelete 50");
        bsTree.delete(50);
        System.out.println("Inorder traversal of the modified tree after deleting 50");
        bsTree.inorder();

        System.out.println("\nDelete 70");
        bsTree.delete(70);
        System.out.println("Inorder traversal of the modified tree after deleting 70");
        bsTree.inorder();


        System.out.println();
        System.out.println("Min value = " + bsTree.minValue(bsTree.root));
        System.out.println("Max value = " + bsTree.maxValue(bsTree.root));


        int pre[] = new int[]{4,2};
        bsTree.root = bsTree.constructTreeFromPreorder(pre, Integer.MAX_VALUE);
        System.out.println("Inorder traversal of the tree constructed from preorder");
        bsTree.inorder();




    }

    private void insert(int key) {
        root = insertRec(root, key);
    }

    private BSTNode insertRec(BSTNode root, int key) {

         /* Base Case: If the tree is empty */
        if (root == null) {
            return new BSTNode(key, null, null);
        }

        if (key < root.value) {
            root.left =  insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    private void delete(int key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, int key) {
         /* Base Case: If the tree is empty */
        if (root == null)
            return null;

          /* Otherwise, recur down the tree */
        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);

        // if key is same as root's key, then This is the node
        // to be deleted
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree) and make it the value for current tree &
            // then delete the
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    private int minValue(BSTNode root) {
        BSTNode node = root;
        while(node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    private int maxValue(BSTNode root) {
        BSTNode node = root;
        while(node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    private void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + ",");
            inorderRec(root.right);
        }
    }


    private BSTNode search(BSTNode root, int key ) {
        if (root == null || root.value == key) {
            return root;
        }

        if (key < root.value)
            return search(root.left, key);

        return search(root.right, key);
    }


    private BSTNode findLowestCommonAncestor(BSTNode root, int v1, int v2) {
        while ( root != null) {
            int value = root.value;

            if (v1 < value && v2 < value) {
                root = root.left;
            } else if (value < v1 && value < v2) {
                root = root.right;
            }
             else
                 return root;
        }
        return null;
    }

    private BSTNode constructTreeFromPreorder(int[] pre, int max) {

        if (index == pre.length || pre[index] > max)
            return null;

        BSTNode root = new BSTNode(pre[index++], null, null);
        root.left = constructTreeFromPreorder(pre, root.value);
        root.right = constructTreeFromPreorder(pre, max);
        return root;
    }

}


class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value, BSTNode left, BSTNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
}



