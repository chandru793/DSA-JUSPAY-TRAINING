import java.util.*;

public class RemoveNthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("Enter size of linked List: ");
        int n = sc.nextInt();
        System.out.println("Enter elements of Linked List: ");
        for (int i = 0; i < n; i++) {
            ll.add(sc.nextInt());
        }
        System.out.println("Enter nth node to be removed: ");
        int rem = sc.nextInt();
        ll.remove(ll.size() - rem);
        System.out.println(ll);
    }
}
