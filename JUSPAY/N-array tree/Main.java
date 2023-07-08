import java.util.*;

public class Main {
    static class TreeNode {
        String name;
        boolean isLocked;
        int id;
        TreeNode parent;
        int anc_locked;
        int des_locked;
        ArrayList<TreeNode> child = new ArrayList<>();

        TreeNode(String name, TreeNode parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int m = 2;
        String[] nodes = new String[] { "World","Asia","Africa", "China", "India","SouthAfrica","Egypt" };
        String[] queries = new String[] { "1 China 9", "1 India 9","3 Asia 9","2 India 9","2 Asia 9"};
        Map<String, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(nodes[0], null);
        map.put(nodes[0], root);
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        int ind = 1;
        
        while (queue.size() > 0 && ind < n) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode removedNode = queue.remove();
                for (int i = 1; i <= m && ind < n; i++) {
                    TreeNode node = new TreeNode(nodes[ind], removedNode);
                    map.put(nodes[ind], node);
                    removedNode.child.add(node);
                    queue.add(node);
                    ind++;
                }
            }
        }

        boolean answer;
        for (String query : queries) {
            String parts[] = query.split(" ");
            if (parts[0].equals("1"))
                answer = lock(map.get(parts[1]), Integer.parseInt(parts[2]));
            else if (parts[0].equals("2"))
                answer = unlock(map.get(parts[1]), Integer.parseInt(parts[2]));
            else
                answer = upgrade(map.get(parts[1]), Integer.parseInt(parts[2]));
            System.out.println(answer);
        }
    }

    static boolean lock(TreeNode node, int id) {
        if (node.isLocked)
            return false;
        if (node.anc_locked > 0 || node.des_locked > 0)
            return false;
        TreeNode cur = node.parent;
        while (cur != null) {
            cur.des_locked += 1;
            cur = cur.parent;
        }
        informDescendant(node, 1);
        node.isLocked = true;
        node.id = id;
        return true;
    }

    static void informDescendant(TreeNode node, int val) {
        if (node == null)
            return;
        node.anc_locked += val;
        for (TreeNode des : node.child)
            informDescendant(des, val);
    }

    static boolean unlock(TreeNode node, int id) {
        if (!node.isLocked || node.id != id)
            return false;
        TreeNode cur = node.parent;
        while (cur != null) {
            cur.des_locked -= 1;
            cur = cur.parent;
        }
        informDescendant(node, -1);
        node.isLocked = false;
        node.id = 0;
        return true;
    }

    static boolean upgrade(TreeNode node, int id) {
        if (node.isLocked || node.anc_locked > 0 || node.des_locked == 0)
            return false;
        ArrayList<TreeNode> child = new ArrayList<>();
        boolean res = getAllChild(node, child, id);
        if (!res)
            return false;
        informDescendant(node, 1);
        for (TreeNode k : child) {
            unlock(k, id);
        }
        node.isLocked = true;
        node.id = id;
        return true;
    }

    static boolean getAllChild(TreeNode node, ArrayList<TreeNode> child, int id) {
        if (node == null)
            return true;
        if (node.isLocked) {
            if (node.id != id)
                return false;
            else
                child.add(node);        
        }
        if (node.des_locked == 0)
            return true;
        for (TreeNode k : node.child) {
            boolean res = getAllChild(k, child, id);
            if (!res)
                return false;
        }
        return true;
    }
}