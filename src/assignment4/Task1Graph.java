package assignment4;

import java.util.*;

public class Task1Graph {

    private final Map<String, List<int[]>> adjList;
    private final List<String> vertices;

    public Task1Graph() {
        adjList = new LinkedHashMap<>();
        vertices = new ArrayList<>();
    }

    public void addVertex(String v) {
        if (!adjList.containsKey(v)) {
            adjList.put(v, new ArrayList<>());
            vertices.add(v);
        }
    }

    public void addEdge(String v, String w, int weight) {
        adjList.get(v).add(new int[]{indexOf(w), weight});
        adjList.get(w).add(new int[]{indexOf(v), weight});
    }

    public int indexOf(String v) {
        return vertices.indexOf(v);
    }

    public String getVertex(int index) {
        return vertices.get(index);
    }

    public List<String> getVertices() {
        return vertices;
    }

    public List<int[]> getNeighbors(String v) {
        return adjList.get(v);
    }

    public void printAdjacencyList() {
        System.out.println("=== Adjacency List ===");
        for (String v : vertices) {
            System.out.print(v + " -> ");
            List<int[]> neighbors = adjList.get(v);
            for (int i = 0; i < neighbors.size(); i++) {
                int[] edge = neighbors.get(i);
                System.out.print(getVertex(edge[0]) + "(" + edge[1] + ")");
                if (i < neighbors.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    // Time:  O(V + E) — visit every vertex and edge once
    // Space: O(V + E) — store all vertices and edges

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

        graph.printAdjacencyList();
    }
}