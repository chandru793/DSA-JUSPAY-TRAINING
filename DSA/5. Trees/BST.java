import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BST {
    Node root;

    BST() {
        root = null;
    }

    // insert elements
    Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.data) {
            node.left = insert(value, node.left);
        } else if (value > node.data) {
            node.right = insert(value, node.right);
        }

        return node;
    }

    // inorder traversal
    void printNode(Node node) {
        if (node == null) {
            return;
        }

        printNode(node.left);
        System.out.print(node.data + " ");
        printNode(node.right);

    }

    // search a node
    Node search(int key, Node node) {
        if (node == null || node.data == key) {
            return node;
        }

        if (key > node.data) {
            return search(key, node.right);
        }
        return search(key, node.left);
    }

    // height of the node
    int height(Node node) {
        if (node == null) {
            return 0;
        }

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    // delete a node
    Node delete(int key, Node node) {

        if (node == null) {
            return node;
        }

        if (key > node.data) {
            node.right = delete(key, node.right);
            return node;
        } else if (key < node.data) {
            node.left = delete(key, node.left);
            return node;
        }

        if (node.left == null) {
            Node temp = node.right;
            return temp;
        } else if (node.right == null) {
            Node temp = node.left;
            return temp;
        } else {
            Node succParent = node;
            Node succ = node.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;   
            }

            if (succParent != node) {
                succParent.left = succ.right;
            }
            else {
            succParent.right = succ.right;
            }

            node.data = succ.data;

            return node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BST tree = new BST();
        tree.root = tree.insert(60, tree.root);
        tree.insert(55, tree.root);
        tree.insert(56, tree.root);
        tree.insert(63, tree.root);
        tree.insert(62, tree.root);
        tree.insert(70, tree.root);
        tree.insert(69, tree.root);
        tree.insert(71, tree.root);
        tree.insert(1, tree.root);

        // inorder traversal
        System.out.println("Inorder traversal : ");
        tree.printNode(tree.root);

        // search
        // System.out.println("Enter an element to search: ");
        // int search = sc.nextInt();
        // if (tree.search(search, tree.root) == null) {
        // System.out.println("Not Found");
        // } else {
        // System.out.println("Found");

        // }

        // height of the tree
        System.out.println();
        System.out.println("Height of the tree: " + (tree.height(tree.root) - 1));

        // deleting a node
        System.out.println("Enter element to delete: ");
        int del = sc.nextInt();
        Node temp = tree.delete(del, tree.root);

        // // inorder traversal
        System.out.println("Inorder traversal : ");
        tree.printNode(temp);

        sc.close();
    }
}
