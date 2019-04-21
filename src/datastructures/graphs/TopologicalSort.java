package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prajnashetty on 3/8/19.
 * Kahn’s algorithm for Topological Sorting
 * Can only be performed on a directed acyclic graph
 */
public class TopologicalSort {

    public static void topologicalSort(DirectedGraph graph) {

    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");

        topologicalSort(graph);
    }

}
