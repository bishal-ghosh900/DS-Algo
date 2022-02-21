
import java.util.*;

class Node {
    int data, height;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.height = 0;
    }
}

class AVLTree {
    Node root;

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public int getHeight(Node node) {
        return node != null ? node.height : -1;
    }

    public Node rotateLeft(Node x) {
        // initialization
        Node y = x.right;
        Node T = y.left;

        // rotation
        y.left = x;
        x.right = T;

        // height update
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    public Node rotateRight(Node x) {
        // initialization
        Node y = x.left;
        Node T = y.right;

        // rotation
        y.right = x;
        x.left = T;

        // height update
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data > node.data) {
            node.right = insert(node.right, data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // left - left
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }
        // left - right
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // right - right
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        // right - left
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void preOrderPrint(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

}

class Main1 {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /*
         * The constructed AVL Tree would be
         * 30
         * / \
         * 20 40
         * / \ \
         * 10 25 50
         */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrderPrint(tree.root);
    }
}