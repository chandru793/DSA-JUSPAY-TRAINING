import java.util.*;

public class palindromeSubString {
    public static Boolean palindrome(String str) {
        StringBuilder rev = new StringBuilder(str);
        if (rev.toString().equals(rev.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String lon = "";
        int n = str.length();

        // O(n^3)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    String t = str.substring(i, k);
                    Boolean r = palindrome(t);
                    if (r && t.length() > lon.length()) {
                        lon = str.substring(i, k);
                    }
                }
            }
        }

        //O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                String t = str.substring(i, j);
                Boolean r = palindrome(t);
                if (r && t.length() > lon.length()) {
                    lon = t;
                }
            }
        }

        System.out.println(lon);
    }
}
