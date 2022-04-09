package boj11724;

import java.util.ArrayList;
import java.util.List;

class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        graph = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0) {
            int u = read();
            int v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int connectedComponent = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponent++;
            }
        }

        System.out.print(connectedComponent);

    }

    static void dfs(int u) {
        visited[u] = true;
        graph.get(u).stream().forEach(v -> {
            if (!visited[v]) dfs(v);
        });
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
