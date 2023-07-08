import java.util.*;

public class maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Read the number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Read the number of cells in the maze
            int[] arr = new int[N]; // Array to store the cell numbers that can be reached

            // Read the elements of the array 'arr'
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int maxCycleLength = -1; // Variable to track the maximum cycle length

            // Iterate over each cell in the maze
            for (int i = 0; i < N; i++) {
                if (arr[i] != -1) { // If the current cell has a valid exit
                    int currentCell = i; // Set the current cell as the starting cell
                    int currentLength = 0; // Length of the current cycle
                    boolean[] visited = new boolean[N]; // Array to mark visited cells

                    // Perform depth-first search (DFS) from the current cell
                    while (arr[currentCell] != -1 && !visited[currentCell]) {
                        visited[currentCell] = true; // Mark the current cell as visited
                        currentLength++; // Increment the current cycle length
                        currentCell = arr[currentCell]; // Move to the next cell
                    }

                    // If the current cell is the same as the starting cell and
                    // the current cycle length is greater than the maximum cycle length,
                    // update the maximum cycle length
                    if (currentCell == i && currentLength > maxCycleLength) {
                        maxCycleLength = currentLength;
                    }
                }
            }

            System.out.println(maxCycleLength); // Print the maximum cycle length for the current test case
        }

        scanner.close();
    }
}
