package Inputs;
import java.util.*;
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] sarr = str.split(" ");
        int[] narr = new int[sarr.length];

        
        System.out.print("After Converting: ");
        for (int i = 0; i < sarr.length; i++) {
            narr[i] = Integer.parseInt(sarr[i]);
            System.out.print(narr[i] + " ");
        }
    }
}
