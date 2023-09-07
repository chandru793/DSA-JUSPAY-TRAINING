import java.util.*;

public class gcd {
    public static void main(String[] args) {
        int num1 = 12, num2 = 24, n = 1;
        
        if(num1!=num2){
            while (n != 0) {
                n = num1 % num2;
                if (n != 0) {
                    num1 = num2;
                    num2 = n;
                }
            }
            System.out.println("HCF : " + num2);
        }else{
            System.out.println("Invalid input");
        }


    }
}
