import java.util.*;

public class Simplebtree {
    private ArrayList<Integer> tree = new ArrayList<>();

    public void insert(int data) {
        tree.add(data);
    }

    private void inorderTraversalHelper(int index) {
        if (index >= tree.size()) {
            return;
        }

        int node = tree.get(index);

        // inorder
        inorderTraversalHelper(2 * index + 1); // line 1
        System.out.print(node + " "); // line2
        inorderTraversalHelper(2 * index + 2); // line 3

        // preorder - line 2,1,3
        // postorder - line 1,3,2
    }

    // To find the maximun height of the tree
    private int maxheight(int index) {
        if (index >= tree.size()) {
            return 0;
        }

        int  left = maxheight(2 * index + 1);
        int right = maxheight(2 * index + 2);

        int maxh = Math.max(left, right) + 1;
        return maxh;
    }

    public static void main(String[] args) {
        Simplebtree binaryTree = new Simplebtree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
                binaryTree.insert(7);
                binaryTree.insert(7);


        System.out.print("Inorder traversal: ");
        binaryTree.inorderTraversalHelper(0);
        
        // To find the maximun height of the tree
        int ans = binaryTree.maxheight(0);
        System.out.println("Maximum Height: "+ans);
    }
}