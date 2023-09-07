import java.util.*;
public class vowAndConst {
    public static void main(String args[]) {
        String str = "chandru";
        str=str.toLowerCase();
        String vowels="aeiou";
        int vow=0;
        int cons=0;

        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                vow += 1;
            } else {
                cons += 1;
            }
        }
        
        System.out.println("Consonants : " + cons);
        System.out.println("Vowels : " + vow);
    }
}
