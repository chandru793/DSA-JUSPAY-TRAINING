import java.util.*;

public class queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // initalize a queue
        // As queue is a interface only linked list
        // or priority queue can access it
        Queue<String> queue = new LinkedList<String>();

        // add element to the queue
        System.out.println("Enter no of elements to be inserted in the Queue: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements to be inserted in the Queue: ");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String ele = sc.nextLine();
            queue.offer(ele);
        }
        System.out.println(queue);

        System.out.println("-------------------------");

        // to return the first element of the queue
        System.out.println("Element in the first of the queue is: " + queue.peek());

        System.out.println("-------------------------");

        // remove first element from the queue
        System.out.println("After removing the first element from the queue");
        queue.poll();
        System.out.println(queue);

        System.out.println("-------------------------");

        //to return the first element of queue using element()
        System.out.println("Element in the first of the queue is: " + queue.element());

        System.out.println("-------------------------");

        //to search the element in the queue
        System.out.println("Enter the element to be searched in the queue:");
        String search = sc.nextLine();
        System.out.println(queue.contains(search));
    }

}
