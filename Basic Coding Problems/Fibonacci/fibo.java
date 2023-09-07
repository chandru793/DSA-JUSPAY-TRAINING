import java.util.*;

public class fibo {
    public static void main(String args[]) {
        int n = 10;
        int a = 0, b = 1;
        
        System.out.print(a + " " + b);

        for (int i = 2; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
            System.out.print(" " + temp);
        }
    }
}
