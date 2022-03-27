package boj1707;

import java.util.ArrayList;
import java.util.List;

class Main {

    static List<AdjacencyList> graph;
    static int[] color;
    static int V, E;

    public static void main(String[] args) throws Exception {

        int K = read();
        graph = new ArrayList<>(20_001);
        color = new int[20_001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 20_000; i++) graph.add(new AdjacencyList());

        while (K-- > 0) {

            V = read();
            E = read();

            for (int i = 1; i <= V; i++) {
                color[i] = 0;
                graph.get(i).init();
            }

            for (int e = 0; e < E; e++) {
                int u = read();
                int v = read();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int v = 1; v <= V; v++)
                if (color[v] == 0) dfs(v, 1);

            sb.append(isBipartiteGraph() ? "YES\n" : "NO\n");

        }

        System.out.print(sb);

    }

    static boolean isBipartiteGraph() {
        for (int u = 1; u <= V; u++) {
            AdjacencyList list = graph.get(u);
            for (int v = 0; v < list.len; v++)
                if (color[u] == color[list.get(v)]) return false;
        }
        return true;
    }

    static void dfs(int v, int c) {

        color[v] = c;
        AdjacencyList list = graph.get(v);

        for (int i = 0; i < list.len; i++) {

            int u = list.get(i);

            if (color[u] == 0) {
                dfs(u, 3 - c);
            }

        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class AdjacencyList {

    int volume;
    int len;
    int[] list;

    AdjacencyList() {
        init();
        volume = 128;
        list = new int[volume];
    }

    void init() {
        len = 0;
    }

    void add(int e) {
        if (len == volume) scaleUp();
        list[len++] = e;
    }

    int get(int i) {
        return list[i];
    }

    void scaleUp() {
        int[] temp = new int[volume <<= 1];
        for (int i = 0; i < len; i++) temp[i] = list[i];
        list = temp;
    }

}
