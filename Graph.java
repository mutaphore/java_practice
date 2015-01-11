import java.util.*;

public class Graph {

    private class Vertex {
        private boolean visited;
        private int id;

        public Vertex(int id) {
            this.id = id;
            this.visited = false;
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

    public boolean isDirected() {
        return this.directed;
    }

    // Extends the adjacent list to contain n vertices
    private void extend(int n) {
        int newSize;

        if (n <= adjLists.size())
            return;

        adjLists.ensureCapacity(n);
        newSize = n - adjLists.size();
        for (int i = 0; i < newSize; i++)
            adjLists.add(new ArrayList<Integer>());
    }

    // Searches in vertices for vertex with id
    private Vertex search(int id) {
        Iterator<Vertex> iter = vertices.iterator();
        Vertex vertex;

        while(iter.hasNext()) {
            vertex = iter.next();
            if (vertex.id == id)
                return vertex;
        }
        return null;
    }

    // Add an edge to graph
    public void addEdge(Integer v1, Integer v2) {
        ArrayList<Integer> adjList;

        if (v1 == v2)
            return;

        // Add to vertices
        if (search(v1) == null)
            vertices.add(new Vertex(v1));
        if (search(v2) == null)
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

    // Deletes an edge from graph
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
        Vertex vertex;

        System.out.print("DFS:");
        for (int i = 0; i < vertices.size(); i++) {
            vertex = vertices.get(i);
            if (!vertex.isVisited()) {
                System.out.println();
                dfs(vertex);
            }
        }
        System.out.println();
    }

    private void dfs(Vertex vertex) {
        Iterator<Integer> iter;
        Vertex adjVertex;

        if (vertex.isVisited())
            return;

        System.out.print(vertex.id + " ");  // Visit
        vertex.visited = true;

        try {
            iter = adjLists.get(vertex.id).iterator();
            while (iter.hasNext()) {
                adjVertex = search(iter.next());
                dfs(adjVertex);
            }
        } catch (Exception e) {
            return;
        }
    }

    public void BFS() {
        Vertex vertex;

        System.out.println("BFS:");
        for (int i = 0; i < vertices.size(); i++) {
            vertex = vertices.get(i);
            if (!vertex.visited)
                dfs(vertex);
        }
        System.out.println();
    }

    private void bfs(Vertex vertex) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<Integer> adjList;
        Vertex curVert, adjVert;

        queue.add(vertex.id);

        while (!queue.isEmpty()) {
            curVert = search(queue.remove(0));
            curVert.visited = true;
            System.out.print(curVert.id);
            adjList = adjLists.get(curVert.id);
            for (int i = 0; i < adjList.size(); i++) {
                adjVert = search(adjList.get(i));
                if (adjVert.visited == false)
                    queue.add(adjList.get(i));
            }
        }
    }

    public void print() {
        ArrayList<Integer> adjList;
        Iterator<Integer> iter;

        System.out.print("Vertices: ");
        for (int i = 0; i < vertices.size(); i++)
            System.out.print(vertices.get(i).id + " ");
        System.out.println();

        System.out.println("Adjancent list:");
        for (int i = 0; i < adjLists.size(); i++) {
            adjList = adjLists.get(i);
            if (adjList != null && adjList.size() > 0)
                System.out.print(i + " -> ");

            iter = adjList.iterator();
            while (iter.hasNext())
                System.out.print(iter.next() + " ");

            if (adjList.size() > 0)
                System.out.println();
        }
    }
}
