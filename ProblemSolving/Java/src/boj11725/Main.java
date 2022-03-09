package boj11725;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();

        // int[] tree = new int[N + 1];
        // for (int i = 1; i <= N; i++) tree[i] = i;

        List<List<Integer>> tree = new ArrayList<>(N);
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for (int i = 2; i <= N; i++) {
            int u = read();
            int v = read();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] parents = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        dfs(1, tree, parents, visited);

        for (int i = 2; i <= N; i++)
            System.out.println(parents[i]);

    }

    // static void dfs(List<Integer> node, boolean[] visited) {
    static void dfs(int index, List<List<Integer>> tree, int[] parents, boolean[] visited) {

        if (visited[index]) return;

        List<Integer> node = tree.get(index);
        int len = node.size();

        for (int i = 0; i < len; i++) {
            int child = node.get(i);
            if (visited[child]) continue;
            parents[child] = index;
            visited[index] = true;
            dfs(child, tree, parents, visited);
            visited[index] = false;
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
