import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        
        ArrayList<Integer> al = new ArrayList<>();
        
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            if (Collections.frequency(al, al.get(i)) == 1) {
                System.out.println(al.get(i));
                break;
            }
        }
    }
}
