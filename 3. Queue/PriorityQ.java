import java.util.*;

public class PriorityQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // initalize a queue
        // As queue is a interface only linked list
        // or priority queue can access it
        PriorityQueue<String> queue = new PriorityQueue<String>();

        // to the elements in higher to lower order
        PriorityQueue<String> queueReverse = new PriorityQueue<String>(Collections.reverseOrder());

        // add element to the queue
        System.out.println("Enter no of elements to be inserted in the Queue: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements to be inserted in the Queue: ");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String ele = sc.nextLine();
            queue.offer(ele);
            queueReverse.offer(ele);
        }
        // while displaying the priority queue it will not be displayed in order.
        // So to print the elements in order we will print by using poll() which removes
        // and prints the value.
        System.out.println(queue);
        System.out.println(queueReverse);

        System.out.println("------------------");

        // deletes the element from the first of the queue
        for (int i = 0; i < n; i++) {
            System.out.println(queue.poll());
        }

        System.out.println("------------------");

        for (int i = 0; i < n; i++) {
            System.out.println(queueReverse.poll());
        }

    }
}
