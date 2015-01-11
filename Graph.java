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

        public boolean isVisited() {
            return this.visited;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex)
                return this.id == ((Vertex)obj).id;
            else
                return false;
        }
    }

    private ArrayList<ArrayList<Integer>> adjLists;
    private ArrayList<Vertex> vertices;
    private boolean directed;

    public Graph() {

        this.directed = false;
        adjLists = new ArrayList<ArrayList<Integer>>();
        vertices = new ArrayList<Vertex>();
        extend(10);
    }

    public Graph(boolean directed) {

        this.directed = directed;
        adjLists = new ArrayList<ArrayList<Integer>>();
        vertices = new ArrayList<Vertex>();
        extend(10);
    }

    private void extend(int n) {
        int newSize;

        if (n <= adjLists.size())
            return;

        adjLists.ensureCapacity(n);
        newSize = n - adjLists.size();
        for (int i = 0; i < newSize; i++)
            adjLists.add(new ArrayList<Integer>());
    }

    private void refresh() {

        for (int i = 0; i < )
    }

    public boolean isDirected() {
        return this.directed;
    }

    public void addEdge(Integer v1, Integer v2) {
        ArrayList<Integer> adjList;

        if (v1 == v2)
            return;

        // Add to vertices
        if (!vertices.contains(v1))
            vertices.add(new Vertex(v1));
        if (!vertices.contains(v2))
            vertices.add(new Vertex(v2));

        // Add to adjacent list
        try {
            extend(Math.max(v1, v2) + 1);
            adjList = adjLists.get(v1);
            if (adjList.indexOf(v2) == -1) {
                adjList.add(v2);
                if (!directed)
                    adjLists.get(v2).add(v1);
            }
        } catch (Exception e) {
            // Index out of bounds
            return;
        }
    }

    public void delEdge(Integer v1, Integer v2) {

        try {
            adjLists.get(v1).remove(v2);
            if (!directed)
                adjLists.get(v2).remove(v1);
        } catch (Exception e) {
            // Index out of bounds
            return;
        }
    }

    public void DFS() {
        refresh();
        // dfs(adjLists.get(0).get(0));
    }

    private void dfs(Vertex vertex) {
        Iterator<Integer> iter;

        if (vertex.visited == true)
            return;

        System.out.println(vertex.id);  // Visit
        vertex.visited = true;

        try {
            iter = adjLists.get(vertex.id).iterator();
            while (iter.hasNext())
                dfs(iter.next());
        } catch (Exception e) {
            return;
        }
    }

    public void print() {
        ArrayList<Integer> adjList;
        Iterator<Integer> iter;

        for (int i = 0; i < adjLists.size(); i++) {
            adjList = adjLists.get(i);
            if (adjList != null && adjList.size() > 0)
                System.out.print(i + ": ");

            iter = adjList.iterator();
            while (iter.hasNext())
                System.out.print(iter.next() + " ");

            if (adjList.size() > 0)
                System.out.println();
        }
    }
}
