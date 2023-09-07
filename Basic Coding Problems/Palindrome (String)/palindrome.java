public class palindrome {
    public static void main(String[] args) {

        String str = "chanahc";
        String revstr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            revstr = ch + revstr;
        }

        if (str.equals(revstr)) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not Palindrome");
        }

    }
}
