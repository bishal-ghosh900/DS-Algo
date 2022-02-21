import java.util.*;

class BinarySearchTree {
    Node root;

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    BinarySearchTree(int data) {
        this.root = new Node(data);
    }

    public Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data > node.data) {
            node.right = insert(node.right, data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        return node;
    }

    public Node delete(Node node, int data) {

        if (node == null) {
            return node;
        }

        if (data > node.data) {
            node.right = delete(node.right, data);
        } else if (data < node.data) {
            node.left = delete(node.left, data);
        } else {

            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node parent = node;
            Node child = node.right;
            while (child.left != null) {
                parent = child;
                child = child.left;
            }
            if (parent == node) {
                parent.right = child.right;
            } else {
                parent.left = child.right;
            }
            node.data = child.data;

        }
        return node;
    }

    public void inOrderPrint(Node root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.print(root.data + " ");
            inOrderPrint(root.right);
        }
    }

}

public class Main1 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);

        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("\nDelete 20");
        tree.delete(tree.root, 20);
        tree.inOrderPrint(tree.root);

        System.out.println("\nDelete 30");
        tree.delete(tree.root, 30);
        tree.inOrderPrint(tree.root);

        System.out.println("\nDelete 50");
        tree.delete(tree.root, 50);
        tree.inOrderPrint(tree.root);

    }
}