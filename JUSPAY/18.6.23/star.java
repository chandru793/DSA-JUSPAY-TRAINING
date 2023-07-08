import java.util.*;

public class star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // initaialize start and end index
        int startIndex[] = new int[2];
        int endIndex[] = new int[2];

        System.out.println("Enter the start index:");
        for (int i = 0; i < 2; i++) {
            startIndex[i] = sc.nextInt();
        }

        System.out.println("Enter the end index:");
        for (int i = 0; i < 2; i++) {
            endIndex[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < 2; i++) {
            count = 0;
            String sub = s.substring(startIndex[i] - 1, endIndex[i]);
            int start = sub.indexOf("|");
            int end = sub.lastIndexOf("|");
            for (int j = start; j < end; j++) {
                if (sub.charAt(j) == '*') {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}
