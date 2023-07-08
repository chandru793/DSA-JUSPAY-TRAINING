import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class binaryTree {
    private ArrayList<Node> tree;

    public binaryTree() {
        tree = new ArrayList<>();
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        tree.add(newNode);
    }

    private void inorderTraversalHelper(int index) {
        if (index >= tree.size()) {
            return;
        }

        Node node = tree.get(index);

        inorderTraversalHelper(2 * index + 1);
        System.out.print(node.data + " ");
        inorderTraversalHelper(2 * index + 2);
    }

    public static void main(String[] args) {
        binaryTree binaryTree = new binaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);

        System.out.print("Inorder traversal: ");
        binaryTree.inorderTraversalHelper(0);
    }
}