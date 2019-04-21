package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajnashetty on 3/11/19.
 */
public class BellmanFordGraph {

    int V;
    List<Edge> edges;


    private class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    BellmanFordGraph (int v) {
        V = v;
        edges = new ArrayList<>();
    }


    public void addEdge(int s, int d, int w) {
        Edge edge = new Edge(s, d, w);
        edges.add(edge);
    }

    void getShortestPathBellManFord(int src) {

        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int i = 0 ; i < (V - 1); i++) {
            for (int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).src;
                int v = edges.get(j).dest;
                int weight = edges.get(j).weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }

            }
        }

        for (int j = 0; j < edges.size(); j++) {
            int u = edges.get(j).src;
            int v = edges.get(j).dest;
            int weight = edges.get(j).weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
            }
        }

        printArr(dist, src);
    }

    private void printArr(int[] dist, int src) {

        System.out.println("Vertex Distance from source ");
        for (int i = 0; i < V; ++i)
            System.out.println("Source Vertex: " + src + " to vertex " +   + i +
                " distance: " + dist[i]);
    }

    public static void main(String[] args)
    {
        int V = 5;  // Number of vertices in graph

        BellmanFordGraph graph = new BellmanFordGraph(V);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.getShortestPathBellManFord(0);
    }
}
