// import java.util.ArrayList;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     public TreeNode(int val) {
//         this.val = val;
//         left = null;
//         right = null;
//     }
// }

// class bst {
//     private ArrayList<TreeNode> tree;

//     public bst() {
//         tree = new ArrayList<>();
//     }

//     public void insert(int val) {
//         if (tree.isEmpty()) {
//             tree.add(new TreeNode(val));
//             return;
//         }

//         TreeNode current = tree.get(0);
//         while (true) {
//             if (val < current.val) {
//                 if (current.left == null) {
//                     current.left = new TreeNode(val);
//                     break;
//                 }
//                 current = current.left;
//             } else {
//                 if (current.right == null) {
//                     current.right = new TreeNode(val);
//                     break;
//                 }
//                 current = current.right;
//             }
//         }
//     }

//     public void inorderTraversal() {
//         inorderTraversal(tree.get(0));
//     }

//     private void inorderTraversal(TreeNode node) {
//         if (node != null) {
//             inorderTraversal(node.left);
//             System.out.print(node.val + " ");
//             inorderTraversal(node.right);
//         }
//     }

//     public static void main(String[] args) {
//         bst bst = new bst();

//         bst.insert(1);
//         bst.insert(3);
//         bst.insert(8);
//         bst.insert(2);
//         bst.insert(4);
//         bst.insert(7);
//         bst.insert(9);

//         bst.inorderTraversal();
//     }
// }



import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int data) {
        this.val = data;
        left = null;
        right = null;
    }
}

public class bst {
    private ArrayList<Node> tree;

    public bst(){
        tree = new ArrayList<>();
    }

    public void insert(int val) {
        if (tree.isEmpty()) {
            tree.add(new Node(val));
        }

        Node current = tree.get(0);

        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new Node(val);
                    break;
                }
                current = current.left;
            }
            else {
                if (current.right==null) {
                    current.right=new Node(val);
                    break;
                }
                current=current.right;
            }
        }
    }

        public void inorder(){
            inorder(tree.get(0));
        }

        private void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.println(node.val);
                inorder(node.right);
            }
        }

        public static void main(String[] args) {
            bst bst = new bst();
            bst.insert(5);
            bst.insert(3);
            bst.insert(6);
            bst.insert(2);
            bst.insert(4);
            bst.insert(8);
            bst.insert(1);
            bst.insert(7);
            bst.insert(9);

            bst.inorder();
        }

}