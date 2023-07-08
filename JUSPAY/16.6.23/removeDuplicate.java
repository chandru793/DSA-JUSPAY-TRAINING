import java.util.*;

public class removeDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements to be inserted: ");
        int n = sc.nextInt();

        ArrayList<Integer> arrlist = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            arrlist.add(ele);
            hs.add(ele);
        }

        System.out.println("Original Array: " + arrlist);
        System.out.println("Removed duplicates: " + hs + " Size: " + hs.size());
    }
}
