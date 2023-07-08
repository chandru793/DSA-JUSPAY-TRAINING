import java.util.*;

public class stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stk = new Stack<String>();

        // to chaeck the stackk is empty or not
        System.out.println("Stack empty or not " + stk.isEmpty());
        System.out.println("Enter no.of elements to be pushed in the stack ");
        int n = sc.nextInt();

        // Dummy input statement to avoid input in the same line as 'n'
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            stk.push(temp);
        }
        System.out.println(stk);

        // Removing the top element using pop()
        stk.pop();
        System.out.println("Removing top most element from the stack... After removing the stack looks like: " + stk);

        System.out.println(stk);

        // Returning the top element of the stack using peek()
        System.out.println("Top most element of the stack is: " + stk.peek());

        // Search the element in the array
        System.out.println("Enter element in the stack to find its position ");
        String search = sc.nextLine();
        System.out.println("The element is found at the position: " + stk.search(search));
    }
}
