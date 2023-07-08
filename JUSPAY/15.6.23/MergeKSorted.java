import java.util.*;

public class MergeKSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("Enter size of linked List: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter elements of Linked List: " + i);
            while (true) {
                String temp = sc.nextLine();
                if (temp == "") {
                    break;
                }
                ll.add(Integer.parseInt(temp));
            }
        }
        Collections.sort(ll);
        System.out.println(ll);
    }
}