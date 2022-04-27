package boj1167;

import utils.io.Reader;

class Main {

    static class Node {
        int v;
        int w;
        Node next;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static Node[] graph;
    static boolean[] visited;
    static int diameter;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();

        graph = new Node[N + 1];
        visited = new boolean[N + 1];

        Node[] lastChild = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            int u = in.nextInt();
            int v = 0;

            while ((v = in.nextSignedInt()) > 0) {
                if (graph[u] == null) {
                    lastChild[u] = graph[u] = new Node(v, in.nextInt());
                } else {
                    lastChild[u] = lastChild[u].next = new Node(v, in.nextInt());
                }
            }
        }

        dfs(1);
        System.out.print(diameter);

    }

    static int dfs(int u) {
        visited[u] = true;

        int a, b, w;
        a = b = 0;

        for (Node node = graph[u]; node != null; node = node.next) {
            if (visited[node.v]) continue;
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

}
