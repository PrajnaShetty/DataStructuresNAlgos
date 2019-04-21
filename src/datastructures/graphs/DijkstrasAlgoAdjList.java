package datastructures.graphs;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by prajnashetty on 3/11/19.
 */
public class DijkstrasAlgoAdjList {

    int V;

    List<Edge>[] adjList;

    private static class Edge {
        int from, to;
        int weight;

        Edge(int f, int t, int w){
            from = f;
            to = t;
            weight = w;
        }
    }

    DijkstrasAlgoAdjList(int v) {
        this.V = v;
        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int src, int dest, int weight) {
        Edge edge1 = new Edge(src, dest, weight);
        adjList[src].add(edge1);

        Edge edge2 = new Edge(dest, src, weight);
        adjList[dest].add(edge2);
    }

    public void dijkstra_GetMinDistances(int sourceVertex) {
        boolean[] visited = new boolean[V];

        //distance used to store the distance of vertex from a source
        int[] distance = new int[V];

        //Initialize all the distance to infinity
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }


        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(V, (o1, o2) -> o1.getKey() - o2.getKey());

        distance[sourceVertex] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[sourceVertex], sourceVertex);
        pq.add(p0);

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> extractedPair = pq.poll();

            int extractedVertex = extractedPair.getValue();

            if (!visited[extractedVertex]) {
                visited[extractedVertex] = true;

                List<Edge> list = adjList[extractedVertex];

                for (Edge edge : list) {
                    int destination = edge.to;

                    if (!visited[destination]) {

                        //relaxation
                        int newDist = distance[extractedVertex] + edge.weight;
                        int currentDist = distance[destination];
                        if (newDist < currentDist) {
                            pq.add(new Pair<>(newDist, destination));
                            distance[destination] = newDist;

                        }

                     }
                }
            }
        }

        printDijkstra(distance, sourceVertex);
    }

    private void printDijkstra(int[] distance, int sourceVertex) {
        System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
        for (int i = 0; i < V ; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                    " distance: " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        DijkstrasAlgoAdjList graph = new DijkstrasAlgoAdjList(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra_GetMinDistances(0);
    }


}
