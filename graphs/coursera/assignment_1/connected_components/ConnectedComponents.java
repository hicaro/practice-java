import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {

    private static void explore(ArrayList<Integer>[] adj, int vertex, int[] visited) {
        visited[vertex] = 1;

        for (Integer neighbor: adj[vertex]) {
            if (visited[neighbor] == 0) {
                explore(adj, neighbor, visited);
            }
        }
    }

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int[] visited = new int[adj.length];

        for (int i=0; i < visited.length; i++) {
            visited[i] = 0;
        }

        int cc = 0;

        for (int vertex=0; vertex < adj.length; vertex++) {
            if (visited[vertex] == 0) {
                cc++;
                explore(adj, vertex, visited);
            }
        }

        return cc;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

