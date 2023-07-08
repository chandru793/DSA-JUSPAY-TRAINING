import java.util.*;

public class atoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            else if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '+') {
                ans = ans + str.charAt(i);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
