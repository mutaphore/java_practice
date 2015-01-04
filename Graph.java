import java.util.*;

public class Graph {

    private class Vertex {
        private boolean visited;
        private int id;

        public Vertex(int id) {
            this.id = id;
            this.visited = false;
        }

        public void visit() {
            this.visited = true;
        }
    }

    private ArrayList<ArrayList<Vertex>> graph;

    public Graph(int n) {

        graph = new ArrayList<ArrayList<Vertex>>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Vertex>());
    }

    public void addEdge(int v1, int v2) {
        ArrayList<Vertex> adjList;
        Iterator<Vertex> iter;
        boolean found;

        if ((v1 < 0 || v1 >= graph.size()) || (v2 < 0 || v2 >= graph.size()))
            return;

        adjList = graph.get(v1);
        iter = adjList.iterator();

        found = false;
        while (iter.hasNext()) {
            if (iter.next().id == v2) {
                found = true;
                break;
            }
        }

        if (!found)
            adjList.add(new Vertex(v2));
    }

    public void deleteEdge(int v1, int v2) {
        ArrayList<Vertex> adjList;

        if ((v1 < 0 || v1 >= graph.size()) || (v2 < 0 || v2 >= graph.size()))
            return;

        adjList = graph.get(v1);
    }

    public void print() {
        ArrayList<Vertex> adjList;
        Iterator<Vertex> iter;

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + ": ");
            adjList = graph.get(i);
            iter = adjList.iterator();
            while (iter.hasNext())
                System.out.print(iter.next().id + " ");
            System.out.println();
        }
    }
}
