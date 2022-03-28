package boj18352;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    static int N, M, K, X;
    static List<List<Integer>> graph;

    static class Node {
        int x;
        int d;
        Node(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        K = read();
        X = read();

        setGraph();
        dijkstra();

        if (graph.get(0).size() == 0) {
            System.out.print(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            graph.get(0).stream().forEach(x -> sb.append(x).append('\n'));
            System.out.print(sb);
        }

    }

    static void dijkstra() {

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.d - b.d);

        final int INF = K + 1;
        for (int i = 1; i <= N; i++) dist[i] = INF;

        dist[X] = 0;
        visited[X] = true;
        pq.add(new Node(X, 0));

        while (!pq.isEmpty()) {

            Node node = pq.poll();

            graph.get(node.x).stream().forEach(x -> {
                if (!visited[x] && dist[x] > node.d) {
                    visited[x] = true;
                    dist[x] = node.d + 1;
                    pq.add(new Node(x, dist[x]));
                }
            });

        }

        List<Integer> list = graph.get(0);

        for (int x = 1; x <= N; x++)
            if (dist[x] == K) list.add(x);

    }

    static void setGraph() throws Exception {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) graph.get(read()).add(read());
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
