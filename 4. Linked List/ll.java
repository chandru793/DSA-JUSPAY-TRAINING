import java.util.*;

public class ll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // initialise linked list
        LinkedList<Integer> ll = new LinkedList<>();

        // get input for the linked list
        System.out.println("Enter no of elements to be inserted: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ll.add(sc.nextInt());
        }

        System.out.println(ll);

        // to check the element present in the list
        System.out.println("Enter element to be searched: ");
        int search = sc.nextInt();
        System.out.println(ll.contains(search));

        // to retrive the index of the element
        System.out.println("The index of the searched element is: " + ll.indexOf(search));

        // to delete the element present in the list
        System.out.println("Enter element index to be deleted: ");
        int delete = sc.nextInt();
        System.out.println(ll.remove(delete));

        System.out.println(ll);

        // creating a list itereator
        ListIterator liter = ll.listIterator();
        System.out.println("List Iterator");

        while (liter.hasNext()) {
            System.out.println(liter.next());
        }

    }
}
