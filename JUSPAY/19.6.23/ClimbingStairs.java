import java.util.*;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no.of Stairs: ");
        int n = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(1);

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                al.add(al.get(i - 2) + al.get(i - 1));
            }
        }

        System.out.println("Possibilities: " + al.get(n));
    }
}
