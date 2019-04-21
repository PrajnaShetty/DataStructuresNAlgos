package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by prajnashetty on 3/7/19.
 */
public class GraphBfsDfs {

    int V;
    List<Integer>[] adjList;

    GraphBfsDfs(int v) {
        V = v;
        adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

    }


    public void addEdge( int src, int dest) {
        adjList[src].add(dest);
    }

    public void printAdjList() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + " -> ");
            for (Integer v1 : adjList[v]) {
                System.out.print(v1 + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

    // O(V+E)
    public void printBfsTraversal(int s) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        System.out.print("\nBFS Traversal from " + s + " : ");
        while(!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            List<Integer> list = adjList[s];
            for(Integer v : list) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

    }


    //O(V+E)
    public void printDfsRecTraversal(int v) {
        boolean visited[] = new boolean[V];

        System.out.print("\nDFS Recursive Traversal from " + v + " : ");
        dfsRec(v, visited);
    }


    //O(V+E)
    private void printDfsItrTraversalForDisconnectedGraphs() {

        boolean visited[] = new boolean[V];

        System.out.print("\nDFS Recursive Traversal for disconnected graphs : ");

        for (int i = 0; i < V ; i++) {
            if (!visited[i]) {
                dfsRec(i, visited);
            }
        }

    }

    private void dfsRec(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print( v + " ");

        List<Integer> list = adjList[v];
        for (Integer i : list) {
            if (!visited[i])
                dfsRec(i, visited);
        }

    }

    public void printDfsItrTraversal(int v) {
        System.out.print("\nDFS Iterative Traversal from " + v + " : ");

        boolean visited[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while(!stack.empty()) {
            v = stack.pop();

            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }


            List<Integer> list = adjList[v];
            for (Integer i : list) {
                if (!visited[i])
                    stack.push(i);
            }

        }
    }

    public static void main(String[] args) {
        int V = 4;
        GraphBfsDfs graph = new GraphBfsDfs(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.printAdjList();

        graph.printBfsTraversal(2);
        graph.printBfsTraversal(0);


        graph.printDfsRecTraversal(2);
        graph.printDfsItrTraversal(2);

        graph.printDfsItrTraversalForDisconnectedGraphs();


    }


}
