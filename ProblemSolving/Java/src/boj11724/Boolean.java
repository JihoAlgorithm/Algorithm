package boj11724;

class Boolean {

    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        graph = new boolean[N + 1][N + 1];
        while (M-- > 0) {
            int u = read();
            int v = read();
            graph[u][v] = graph[v][u] = true;
        }

        visited = new boolean[N + 1];
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
        if (visited[u]) return;
        visited[u] = true;

        boolean[] adjList = graph[u];

        for (int v = 1; v <= N; v++) {
            if (adjList[v]) dfs(v);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
