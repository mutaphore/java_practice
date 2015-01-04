import java.util.*;

public class GraphDriver {

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(100,5);

        graph.print();
    }
}
