import java.util.*;

public class Graph {

    private ArrayList<Item>[] adj;
    private int initial_size = 2;

    private class Item{
        Integer destination;
        Integer weight;

        Item(Integer d, Integer w) {
            destination = d;
            weight = w;
        }
    }

    public Graph(){
        this.adj = (ArrayList<Item>[]) new ArrayList[this.initial_size];

        for(int i=0; i < this.initial_size; i++){
            this.adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(Integer source, Integer destination, Integer weight){

        int size_required = Math.max(source, destination) + 1;

        if (this.adj.length < size_required) {
            ArrayList<Item>[] new_list = (ArrayList<Item>[]) new ArrayList[size_required];

            // copy the existing lists to the new list
            for (int i=0; i < this.adj.length; i++) {
                new_list[i] = this.adj[i];
            }

            // create List Instances for the new items
            for(int i=this.adj.length; i < size_required; i++){
                new_list[i] = new ArrayList<>();
            }

            this.adj = new_list;
        }

        this.adj[source].add(new Item(destination, weight));
        this.adj[destination].add(new Item(source, weight));
    }

    public int getVertexCount(){
        return this.adj.length;
    }

    private void explore(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex);

        for (Item neighbor: this.adj[vertex]){
            if(! visited[neighbor.destination]) {
                this.explore(neighbor.destination, visited);
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

            for (Item neighbor : this.adj[vertex]){
                if(dist[neighbor.destination] == -1) {
                    q.add(neighbor.destination);
                    dist[neighbor.destination] = dist[vertex] + 1;
                    prev[neighbor.destination] = vertex;
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
        System.out.println("Adjacency List");
        System.out.println("Vertices: " + this.getVertexCount());

        for(int i=0; i < this.adj.length; i++){
            System.out.print(i + ":");

            for(int j=0; j < this.adj[i].size(); j++){
                System.out.print(" " + this.adj[i].get(j).destination);
            }

            System.out.println();
        }
    }

}
