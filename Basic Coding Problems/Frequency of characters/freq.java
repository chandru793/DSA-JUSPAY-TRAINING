import java.util.*;
public class freq {
    public static void main(String args[]) {
        String str = "chandruchan";
        char[] arr = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey()+" - "+e.getValue());
        }
    }
}
