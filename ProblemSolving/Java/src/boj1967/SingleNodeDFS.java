package boj1967;

import java.util.ArrayList;
import java.util.List;

import utils.io.Reader;

class SingleNodeDFS {

    static List<List<Node>> graph;
    static List<Node> adjList;
    static int diameter;

    static class Node {
        int v;
        int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < N; i++)
            graph.get(in.nextInt()).add(new Node(in.nextInt(), in.nextInt()));

        dfs(1);
        System.out.print(diameter);

    }

    static int dfs(int root) {
        int a, b, w;
        a = b = 0;

        adjList = graph.get(root);

        for (Node node : adjList) {
            w = dfs(node.v) + node.w;
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
