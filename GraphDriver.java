import java.util.*;

public class GraphDriver {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 5);
        graph.addEdge(100, 5);
        graph.addEdge(1, 8);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 1);

        graph.delEdge(2, 5);
        graph.delEdge(2, 5);
        graph.delEdge(102, -1);
        graph.delEdge(2, 2);

        graph.print();

        graph.DFS();
        graph.BFS();
    }
}
