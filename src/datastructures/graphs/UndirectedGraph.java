package datastructures.graphs;

import java.util.*;

/**
 * Created by prajnashetty on 3/7/19.
 */
public class UndirectedGraph {

    int V;
    List<Integer>[] adjList;

    UndirectedGraph(int v) {
        V = v;
        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

    }


    public void addEdge( int src, int dest) {
        adjList[src].add(dest);

        adjList[dest].add(src);
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + " -> ");
            for (Integer v1 : adjList[v]) {
                System.out.print(v1 + ",");
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int V = 5;
        UndirectedGraph graph = new UndirectedGraph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

    }
}

