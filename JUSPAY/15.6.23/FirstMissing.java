import java.util.*;

public class FirstMissing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();

        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        Collections.sort(al);
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (al.get(i) > 0 && al.get(i) != count) {
                System.out.println("First Missing positive integer :" + count);
                break;
            } else if (al.get(i) > 0) {
                if (i == 0) {
                    System.out.println("1.. "+count);
                    count++;
                    System.out.println("2.. "+count);
                } else if (i > 0 && al.get(i) != al.get(i - 1)) {
                    System.out.println("3.. "+count);
                    count++;
                    System.out.println("4.. "+count);
                    if (i == n - 1) {
                        System.out.println("First Missing positive integer :" + count);
                    }
                }
            }
        }
    }
}
