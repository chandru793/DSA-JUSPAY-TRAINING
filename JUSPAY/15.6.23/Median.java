import java.util.*;

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Enter the size of arr1: ");
        int m = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            al.add(sc.nextInt());
        }

        System.out.println("Enter the size of arr2: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        // sorting arraylist
        Collections.sort(al);

        int len = al.size();
        if (len % 2 == 1) {
            int ans = len / 2;
            float res = al.get(ans);
            System.out.println("Median: "+al.get(ans));
        } else {
            int ans = len / 2;
            float res = (al.get(ans - 1) + al.get(ans));
            res = res / 2;
            System.out.println("Median: "+res);
        }
    }
}
