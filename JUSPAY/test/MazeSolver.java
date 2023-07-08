import java.util.*;

public class MazeSolver {
    public static int findNearestMeetingCell(int[] edges, int cell1, int cell2) {
        int n = edges.length;
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();

        while (cell1 != -1 || cell2 != -1) {
            if (cell1 != -1) {
                if (visited2.contains(cell1))
                    return cell1;
                visited1.add(cell1);
                cell1 = edges[cell1];
            }

            if (cell2 != -1) {
                if (visited1.contains(cell2))
                    return cell2;
                visited2.add(cell2);
                cell2 = edges[cell2];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] edges = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }

        int cell1 = scanner.nextInt();
        int cell2 = scanner.nextInt();

        int nearestMeetingCell = findNearestMeetingCell(edges, cell1, cell2);
        System.out.println(nearestMeetingCell);

        scanner.close();
    }
}