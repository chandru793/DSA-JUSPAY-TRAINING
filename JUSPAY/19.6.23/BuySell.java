import java.util.*;

public class BuySell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();

        System.out.println("Enter the stock size: ");
        int n = sc.nextInt();

        System.out.println("Enter the stock: ");
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        Collections.reverse(al);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int sub = al.get(i) - al.get(j);
                if (sub > max) {
                    max = sub;
                }
            }
        }

        System.out.println("Profit: " + max);
    }
}
