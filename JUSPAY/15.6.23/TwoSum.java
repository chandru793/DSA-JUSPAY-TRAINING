import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements to be inserted: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        Boolean flag = false;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i; j < n - 1; j++) {
                if ((arr[i] + arr[j]) == target) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("[ " + i + ", " + j + "]");
                break;
            }
        }

        if (!flag) {
            System.out.println("No such element for target");
        }
    }
}
