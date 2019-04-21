package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prajnashetty on 3/8/19.
 */
public class DirectedGraph {
    int V;
    List<Integer>[] adjList;

    DirectedGraph(int v) {
        V = v;
        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

    }


    public void addEdge( int src, int dest) {
        adjList[src].add(dest);
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
        DirectedGraph graph = new DirectedGraph(V);

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
