package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prajnashetty on 3/7/19.
 *
 * Given a directed graph, check whether the graph contains a cycle or not.
 * Your function should return true if the given graph contains at least one cycle, else return false.
 *
 */
public class CycleInDirectedGraph {

    int V;
    List<Integer>[] adjList;

    CycleInDirectedGraph(int v) {
        this.V = v;

        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public void addEdge( int src, int dest) {
        adjList[src].add(dest);
    }

    public static void main(String[] args) {
        int V = 4;
        CycleInDirectedGraph graph = new CycleInDirectedGraph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("isCyclic = " + graph.isCyclic());
    }

    private boolean isCyclic() {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++ ) {
            if (isCyclicUtil(i, visited, recStack))
                return true;

        }

        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {

        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        List<Integer> children = adjList[v];
        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack))
                return true;
        }

        recStack[v] = false;
        return false;

    }

}


