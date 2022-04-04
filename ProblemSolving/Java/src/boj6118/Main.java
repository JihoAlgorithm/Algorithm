package boj6118;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        List<List<Integer>> graph = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = read(); i > 0; i--) {
            int u = read();
            int v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>(N);
        boolean[] visited = new boolean[N + 1];
        int dist = 0;

        int[] barn = new int[N];
        int top = 0;

        visited[1] = true;
        queue.offer(1);

        while (true) {

            int size = queue.size();

            while (size-- > 0) {

                int u = queue.poll();
                barn[top++] = u;

                graph.get(u).stream().forEach(v -> {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                });

            }

            if (queue.isEmpty()) break;
            dist++;
            top = 0;

        }

        java.util.Arrays.sort(barn, 0, top);
        StringBuilder sb = new StringBuilder();
        sb.append(barn[0]).append(' ').append(dist).append(' ').append(top);
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
