package boj1446;

import java.util.*;

class Main {

    static class Edge {
        int to;
        int dist;
        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {

        int N = read();
        int L = read();
        int INF = L + 1;

        Set<Integer> nodeSet = new HashSet<>();
        nodeSet.add(0);
        nodeSet.add(L);

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {

            int f = read();
            int t = read();
            int d = read();

            nodeSet.add(f);
            nodeSet.add(t);

            if (INF <= t) INF = t + 1;

            graph.computeIfAbsent(f, k -> new ArrayList<>()).add(new Edge(t, d));

        }

        nodeSet.stream().sorted().reduce((f, t) -> {
            graph.computeIfAbsent(f, k -> new ArrayList<>()).add(new Edge(t, t - f));
            return t;
        });

        ArrayDeque<Edge> queue = new ArrayDeque<>();
        int[] distance = new int[INF];

        for (int i = 0; i < INF; i++) distance[i] = INF;

        queue.offer(new Edge(0, 0));
        distance[0] = 0;

        while (!queue.isEmpty()) {

            int from = queue.peek().to;
            int dist = queue.poll().dist;

            if (!graph.containsKey(from)) continue;

            graph.get(from).stream().forEach(e -> {
                int newDist = dist + e.dist;
                if (distance[e.to] > newDist)
                    queue.offer(new Edge(e.to, distance[e.to] = newDist));
            });

        }

        System.out.print(distance[L]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
