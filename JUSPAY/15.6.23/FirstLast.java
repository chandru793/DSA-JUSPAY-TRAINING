import java.util.*;

public class FirstLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Enter the size of arr1: ");
        int m = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            al.add(sc.nextInt());
        }
        Collections.sort(al);

        System.out.println("Enter the element to be searched:");
        int target = sc.nextInt();
        System.out.println("First occurence: " + al.indexOf(target));
        System.out.println("Last occurence: " + al.lastIndexOf(target));
    }
}
