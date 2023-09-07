import java.util.*;

public class anagram {
    public static void main(String args[]) {
        String str1 = "chandru";
        String str2 = "chanurd";
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (Arrays.equals(ch1, ch2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not a Anagram");
        }

    }
}
