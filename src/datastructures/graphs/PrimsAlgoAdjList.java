package datastructures.graphs;

import java.util.*;

/**
 * Created by prajnashetty on 3/8/19.
 *
 * Complexity
 * O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV)
 */
public class PrimsAlgoAdjList {

    int V;
    List<Edge>[] adjList;

    private static class Edge{
        int from, to;
        int weight;

        Edge(int f, int t, int w){
            from = f;
            to = t;
            weight = w;
        }
    }

    PrimsAlgoAdjList(int v) {
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


    private List<Edge> prims() {
        if (adjList.length == 0)
            throw new NullPointerException("Graph is empty");

        List<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, (o1, o2) -> o1.weight - o2.weight );

        for (Edge edge : adjList[0]) {
            pq.add(edge);
        }

        boolean[] visited = new boolean[V];
        visited[0] = true;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.from] && visited[edge.to])
                continue;

            visited[edge.from] = true;

            for (Edge e : adjList[edge.to]) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }

            visited[edge.to] = true;
            mst.add(edge);
        }

        return mst;
    }


    public static void main(String[] args) {
        PrimsAlgoAdjList graph = new PrimsAlgoAdjList(9);

        graph.addEdge( 0, 1, 4);
        graph.addEdge( 0, 7, 8);
        graph.addEdge( 1, 2, 8);
        graph.addEdge( 1, 7, 11);
        graph.addEdge( 2, 3, 7);
        graph.addEdge( 2, 8, 2);
        graph.addEdge( 2, 5, 4);
        graph.addEdge( 3, 4, 9);
        graph.addEdge( 3, 5, 14);
        graph.addEdge( 4, 5, 10);
        graph.addEdge( 5, 6, 2);
        graph.addEdge( 6, 7, 1);
        graph.addEdge( 6, 8, 6);
        graph.addEdge( 7, 8, 7);

        List<Edge> mst = graph.prims();
        System.out.println("MST: ");
        for(Edge e : mst){
            System.out.println(e.from+" - "+e.to+" : "+e.weight);
        }
    }


}
