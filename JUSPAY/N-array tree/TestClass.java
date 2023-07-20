import java.util.*;

public class TestClass {
    static class TreeNode {
        boolean isLocked;
        int id;
        String name;
        TreeNode parent;
        int anc_locked;
        int des_locked;
        ArrayList<TreeNode> child = new ArrayList<>();
        Object lock = new Object();

        TreeNode(String name, TreeNode parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int q = sc.nextInt();
        // sc.nextLine();
        // String[] nodes = new String[n];
        // for (int i = 0; i < n; i++) {
        // nodes[i] = sc.nextLine();
        // }
        // String[] queries = new String[q];
        // for (int i = 0; i < q; i++) {
        // queries[i] = sc.nextLine();
        // }

        int n = 7, m = 2, q = 5;
        String[] nodes = new String[] { "World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt" };
        String[] queries = new String[] { "1 China 9", "1 India 9", "2 India 9", "3 Asia 9", "1 Asia 9" };
        String[] queries2 = new String[] { "2 China 9", "2 India 9", "2 India 9", "2 Asia 9", "2 Asia 9" };

        Map<String, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(nodes[0], null);
        map.put(nodes[0], root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ind = 1;

        while (ind < n && queue.size() > 0) {
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

        Object lock = new Object();

        // Thread ArrayList to store the threads
        ArrayList<Thread> threads = new ArrayList<>();
        // Thread 1
        // Thread queryThread = new Thread(() -> {

        // System.out.println("Thread 1");
        for (String query : queries) {
            String[] parts = query.split(" ");

            // try{
            // Thread.sleep(5000);
            // }
            // catch (Exception e) {
            // System.out.println(e);
            // }
            Thread ql = new Thread(() -> {
                if (parts[0].equals("1")) {
                    // Added synchronization
                    synchronized (lock) {
                        System.out.println(
                                "Lock1 " + parts[1] + " " + lock(map.get(parts[1]), Integer.parseInt(parts[2])));
                    }
                } else if (parts[0].equals("2")) {
                    // Added synchronization
                    synchronized (lock) {
                        System.out.println(
                                "UnLock1 " + parts[1] + " " + unlock(map.get(parts[1]), Integer.parseInt(parts[2])));
                    }
                } else {
                    // Added synchronization
                    synchronized (lock) {
                        System.out.println(
                                "Upgrade1 " + parts[1] + " " + upgrade(map.get(parts[1]), Integer.parseInt(parts[2])));
                    }
                }
            });
            threads.add(ql);
        }
        // });

        // threads.add(queryThread);
        // Start the query thread
        // queryThread.start();

        // try {
        // queryThread.join();
        // } catch (Exception e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }

        // Thread 2
        // Thread queryThread2 = new Thread(() -> {

        // // System.out.println("Thread 2");
        // for (String query : queries2) {
        // String[] parts = query.split(" ");
        // try{
        // Thread.sleep(5000);
        // }
        // catch(Exception e){
        // System.out.println(e);
        // }
        // if (parts[0].equals("1")) {
        // // Added synchronization
        // synchronized (lock) {
        // System.out.println(
        // "Lock2 " + parts[1] + " " + lock(map.get(parts[1]),
        // Integer.parseInt(parts[2])));
        // }
        // } else if (parts[0].equals("2")) {
        // // Added synchronization
        // synchronized (lock) {
        // System.out.println(
        // "Unlock2 " + parts[1] + " " + unlock(map.get(parts[1]),
        // Integer.parseInt(parts[2])));
        // }
        // } else {
        // // Added synchronization
        // synchronized (lock) {
        // System.out.println(
        // "Upgrade2 " + parts[1] + " " + upgrade(map.get(parts[1]),
        // Integer.parseInt(parts[2])));
        // }
        // }
        // }
        // });

        // threads.add(queryThread2);
        // Start the query thread
        // queryThread2.start();

        // try {
        // queryThread2.join();
        // } catch (Exception e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }

        System.out.println("");
        System.out.println("========================");
        System.out.println("========================");
        System.out.println("");

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
            System.out.println("thread start : "+thread);
        }
        
        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println("join thread : "+thread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static boolean lock(TreeNode node, int id) {

        synchronized (node.lock) {
            if (node.isLocked) {
                return false;
            }
            if (node.anc_locked > 0 || node.des_locked > 0) {
                return false;
            }

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
    }

    static void informDescendant(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        node.anc_locked += val;
        for (TreeNode des : node.child) {
            informDescendant(des, val);
        }

    }

    static boolean unlock(TreeNode node, int id) {
        synchronized (node.lock) {
            if (!node.isLocked || node.id != id) {
                return false;
            }
            TreeNode cur = node.parent;
            while (cur != null) {
                node.des_locked -= 1;
                cur = cur.parent;
            }
            informDescendant(node, -1);
            node.isLocked = false;
            node.id = 0;
            return true;
        }
    }

    static boolean upgrade(TreeNode node, int id) {
        synchronized (node.lock) {
            if (node.isLocked || node.anc_locked > 0 || node.des_locked == 0) {
                return false;
            }

            ArrayList<TreeNode> child = new ArrayList<>();
            boolean res = getAllChild(node, child, id);
            if (!res) {
                return false;
            }

            informDescendant(node, id);
            for (TreeNode des : child) {
                unlock(des, id);
            }
            node.isLocked = true;
            node.id = id;
            return true;
        }

    }

    static boolean getAllChild(TreeNode node, ArrayList<TreeNode> child, int id) {
        synchronized (node.lock) {
            if (node == null) {
                return true;
            }
            if (node.isLocked) {
                if (node.id != id) {
                    return false;
                } else {
                    child.add(node);
                }
            }

            if (node.des_locked == 0) {
                return true;
            }
            for (TreeNode des : node.child) {
                boolean res = getAllChild(des, child, id);
                if (!res) {
                    return false;
                }
            }
            return true;
        }
    }
}
