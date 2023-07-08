import java.util.*;

public class swapPairs {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.println(ll);

        for (int i = 0; i < ll.size()-1; i += 2) {
            int temp = ll.get(i);
            ll.set(i, ll.get(i + 1));
            ll.set(i + 1, temp);
        }

        System.out.println(ll);
    }
}
