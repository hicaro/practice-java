import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int adj[][];
    private int initial_size = 2;


    public Graph(){
        this.adj = new int[this.initial_size][this.initial_size];
    }

    public void addEdge(Integer source, Integer destination, Integer weight) {

        int size_required = Math.max(source, destination) + 1;

        if (this.adj.length < size_required) {
            int[][] new_matrix = new int[size_required][size_required];

            for(int i=0; i < this.adj.length; i++){
                for(int j=0; j < this.adj[i].length; j++){
                    new_matrix[i][j] = this.adj[i][j];
                }
            }

            for(int i=this.adj.length; i < size_required; i++){
                for(int j=this.adj.length; j < size_required; j++){
                    new_matrix[i][j] = 0;
                }
            }

            this.adj = new_matrix;
        }

        this.adj[source][destination] = weight;
        this.adj[destination][source] = weight;
    }

    public int getVertexCount(){
        return this.adj.length;
    }

    private void explore(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);

        for(int neighbor=0; neighbor < this.adj[vertex].length; neighbor++){
            if(this.adj[vertex][neighbor] > 0 && ! visited[neighbor]){
                this.explore(neighbor, visited);
            }
        }
    }

    public void DFS(){
        System.out.println("DFS");
        boolean visited[] = new boolean[this.adj.length];

        // for all v belonging to V, mark as unvisited
        for(int i=0; i < visited.length; i++){
            visited[i] = false;
        }

        for(int i=0; i < this.adj.length; i++){
            if(! visited[i]){
                explore(i, visited);
            }
        }

    }

    public void BFS(){
        System.out.println("BFS");

        int[] dist = new int[this.adj.length];
        int[] prev = new int[this.adj.length];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i < this.adj.length; i++) {
            dist[i] = -1;
            prev[i] = -1;
        }

        dist[0] = 0;

        q.add(0);

        while (!q.isEmpty()) {
            int vertex = q.remove();

            for (int neighbor=0; neighbor < this.adj[vertex].length; neighbor++){
                if(this.adj[vertex][neighbor] > 0 & dist[neighbor] == -1) {
                    q.add(neighbor);
                    dist[neighbor] = dist[vertex] + 1;
                    prev[neighbor] = vertex;
                }
            }
        }
        System.out.println("Distances and previous");
        for(int i=0; i < this.adj.length; i++) {
            System.out.println("Vertex " + i + ": " + dist[i] + " - Previous: " + prev[i]);
        }
    }

    public void countComponents() {
        boolean[] visited = new boolean[this.adj.length];

        for (int i=0; i < visited.length; i++) {
            visited[i] = false;
        }

        int cc = 0;

        for (int vertex=0; vertex < this.adj.length; vertex++) {
            if (!visited[vertex]) {
                cc++;
                explore(vertex, visited);
            }
        }

        System.out.println("Connected components: " + cc);
    }

    public void printDebug(){
        System.out.println("Adjacency Matrix");
        System.out.println("Vertices: " + this.getVertexCount());

        for(int i=0; i < this.adj.length; i++){
            System.out.print(i + ":");

            for(int j=0; j < this.adj[i].length; j++){
                if(this.adj[i][j] > 0) {
                    System.out.print(" " + j);
                }
            }

            System.out.println();
        }
    }
}
