package Inputs;
import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        // ArrayList<String> sal = new ArrayList<>();

        while (true) {
            String temp = sc.nextLine();
            if (temp == "") {
                break;
            }
            al.add(Integer.parseInt(temp));
            // sal.add(temp);
        }
        System.out.println(al);
    }
}
