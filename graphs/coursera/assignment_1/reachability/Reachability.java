import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        return search(adj, x, y);
    }

    private static void explore(ArrayList<Integer>[] adj, int vertex, int[] visited) {
        visited[vertex] = 1;

        for (Integer neighbor : adj[vertex]) {
            if (visited[neighbor] == 0){
                explore(adj, neighbor, visited);
            }
        }
    }

    private static int search(ArrayList<Integer>[] adj, int init, int target) {
        int[] visited = new int[adj.length];

        for (int i=0; i < visited.length; i++){
            visited[i] = 0;
        }

        explore(adj, init, visited);

        return visited[target];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        System.out.println(reach(adj, x, y));
    }
}

