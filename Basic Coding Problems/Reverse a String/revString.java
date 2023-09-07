public class revString {
    public static void main(String[] args) {

        String str = "Chandru";
        String revstr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            revstr = ch + revstr;
        }

        System.out.println(revstr);

    }
}
