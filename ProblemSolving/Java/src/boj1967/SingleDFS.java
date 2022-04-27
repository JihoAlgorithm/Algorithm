package boj1967;

import java.util.ArrayList;
import java.util.List;

import utils.io.Reader;

class SingleDFS {

    static List<List<Integer>> graph;
    static List<Integer> adjList;
    static int diameter;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            graph.get(u).add(encode(v, w));
        }

        dfs(1);
        System.out.print(diameter);

    }

    static int dfs(int root) {
        int a, b, w;
        a = b = 0;

        adjList = graph.get(root);

        for (int node : adjList) {
            w = dfs(getV(node)) + getW(node);
            if (a < w) {
                b = a;
                a = w;
            } else if (b < w) {
                b = w;
            }
        }

        w = a + b;
        if (diameter < w) diameter = w;

        return a;
    }

    static int encode(int v, int w) {
        return v << 7 | w;
    }

    static int getV(int node) {
        return node >> 7;
    }

    static int getW(int node) {
        return node & 127;
    }

}
