package boj1967;

import utils.io.Reader;

class SingleDFSLikedList {

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
    static int diameter;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();

        graph = new Node[N + 1];
        Node[] lastChild = new Node[N + 1];

        for (int i = 1; i < N; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            if (graph[u] == null) {
                lastChild[u] = graph[u] = new Node(v, w);
            } else {
                lastChild[u] = lastChild[u].next = new Node(v, w);
            }
        }

        dfs(1);
        System.out.print(diameter);

    }

    static int dfs(int u) {
        int a, b, w;
        a = b = 0;

        for (Node node = graph[u]; node != null; node = node.next) {
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
