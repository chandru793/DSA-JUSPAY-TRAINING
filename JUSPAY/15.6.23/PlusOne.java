import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        System.out.println("Enter elements of array: ");
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (i == n - 1) {
                arr[i] = temp + 1;
            } else {
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
