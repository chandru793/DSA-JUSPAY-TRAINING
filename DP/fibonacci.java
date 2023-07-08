import java.util.*;

public class fibonacci {

    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // recursive method
        if (n >= 0) {
            System.out.println(fib(n, dp));
        } else {
            System.out.println("Invalid input");
        }

        // best method
        int[] dp2 = new int[n + 1];
        dp2[0] = 0;
        dp2[1] = 1;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                dp2[i] = dp2[i - 1] + dp2[i - 2];
            }
            System.out.println(dp2[n]);
        } else if (n == 0 || n == 1) {
            System.out.println(dp2[n]);
        } else {
            System.out.println("Invalid input");
        }

        // optimal method
        int prev2 = 0, prev = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                int curr = prev2 + prev;
                prev2 = prev;
                prev = curr;
            }
            System.out.println(prev);
        } else if (n == 0 || n == 1) {
            System.out.println(n);
        } else {
            System.out.println("Invalid input");
        }
    }
}