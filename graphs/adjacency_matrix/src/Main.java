public class Main {

    public static void main(String[] args){
        Graph g = new Graph();

        g.addEdge(0, 1, 5);
        g.addEdge(0, 5, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 4, 5);
        g.addEdge(2, 6, 4);
        g.addEdge(3, 2, 5);
        g.addEdge(5, 8, 2);
        g.addEdge(6, 5, 7); // uncomment to create cycle
        g.addEdge(7, 5, 3);
        g.addEdge(8, 6, 3); // uncomment to create cycle
        g.addEdge(4, 1, 2); // uncomment to create cycle

        //g.DFS();
        //g.BFS();
        g.printDebug();

        //g.countComponents();
    }
}
