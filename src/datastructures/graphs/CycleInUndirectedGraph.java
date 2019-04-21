package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prajnashetty on 3/8/19.
 */
public class CycleInUndirectedGraph {

    int V;
    List<Integer>[] adjList;

    CycleInUndirectedGraph(int v) {
        this.V = v;

        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public void addEdge( int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public static void main(String[] args) {
        int V = 5;
        CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(V);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        System.out.println("isCyclic G1 = " + g1.isCyclic());

        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);

        System.out.println("isCyclic G2 = " + g2.isCyclic());
    }

    //O(V+E)
    private boolean isCyclic() {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++ ) {
            if (!visited[i])
                if (isCyclicUtil(i, visited, -1))
                    return true;

        }

        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {

        visited[v] = true;

        List<Integer> list = adjList[v];
        for (Integer i : list) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if ( i != parent)
                return true;
        }

        return false;

    }
}
