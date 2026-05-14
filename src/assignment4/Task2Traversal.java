package assignment4;

import java.util.*;

public class Task2Traversal {

    // DFS using recursion
    // Time:  O(V + E) — visits every vertex and edge once
    // Space: O(V)     — recursion stack depth

    static void dfs(Task1Graph graph, String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int[] neighbor : graph.getNeighbors(node)) {
            String next = graph.getVertex(neighbor[0]);
            if (!visited.contains(next)) {
                dfs(graph, next, visited);
            }
        }
    }

    // BFS using a queue
    // Time:  O(V + E) — visits every vertex and edge once
    // Space: O(V)     — queue holds at most all vertices

    static void bfs(Task1Graph graph, String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");

            for (int[] neighbor : graph.getNeighbors(node)) {
                String next = graph.getVertex(neighbor[0]);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {

        Task1Graph graph = new Task1Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("B", "A", 12);
        graph.addEdge("C", "B", 4);
        graph.addEdge("D", "B", 2);
        graph.addEdge("E", "D", 2);
        graph.addEdge("F", "C", 7);
        graph.addEdge("C", "A", 15);
        graph.addEdge("F", "D", 12);
        graph.addEdge("A", "F", 3);

        System.out.println("=== DFS Traversal (starting from E) ===");
        Set<String> visited = new LinkedHashSet<>();
        dfs(graph, "E", visited);
        System.out.println();

        System.out.println("=== BFS Traversal (starting from E) ===");
        bfs(graph, "E");
        System.out.println();
    }
}