package assignment4;

import java.util.*;

public class Task3Dijkstra {

    // Dijkstra's Algorithm using priority queue
    // Time:  O((V + E) log V) — priority queue processes each vertex and edge
    // Space: O(V)             — distance array and previous node tracker

    static void dijkstra(Task1Graph graph, String source) {

        List<String> vertices = graph.getVertices();
        int n = vertices.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[graph.indexOf(source)] = 0;

        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, graph.indexOf(source)});

        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int currDist = current[0];
            int currIdx  = current[1];

            if (visited.contains(currIdx)) continue;
            visited.add(currIdx);

            String currNode = graph.getVertex(currIdx);

            for (int[] neighbor : graph.getNeighbors(currNode)) {
                int nextIdx    = neighbor[0];
                int edgeWeight = neighbor[1];

                if (!visited.contains(nextIdx)) {
                    int newDist = currDist + edgeWeight;

                    if (newDist < dist[nextIdx]) {
                        dist[nextIdx] = newDist;
                        prev[nextIdx] = currIdx;
                        pq.add(new int[]{newDist, nextIdx});
                    }
                }
            }
        }

        System.out.println("=== Dijkstra Shortest Path (Source = " + source + ") ===");
        System.out.println();

        for (int i = 0; i < n; i++) {
            String target = graph.getVertex(i);

            if (target.equals(source)) continue;

            System.out.print("C -> " + target + " | Distance: ");

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("unreachable");
            } else {
                System.out.print(dist[i] + " | Path: ");

                List<String> path = new ArrayList<>();
                int step = i;
                while (step != -1) {
                    path.add(graph.getVertex(step));
                    step = prev[step];
                }
                Collections.reverse(path);
                System.out.println(String.join(" -> ", path));
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

        dijkstra(graph, "C");
    }
}