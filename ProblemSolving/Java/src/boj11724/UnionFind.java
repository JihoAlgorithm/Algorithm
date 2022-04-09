package boj11724;

class UnionFind {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int[] set = new int[N + 1];
        int connectedComponent = N;

        for (int i = 0; i <= N; i++) set[i] = -1;

        while (M-- > 0)
            if (union(read(), read(), set))
                if (--connectedComponent == 1) break;

        System.out.print(connectedComponent);

    }

    private static boolean union(int u, int v, int[] s) {

        if ((u = find(u, s)) == (v = find(v, s)))
            return false;

        if (s[u] < s[v]) {
            s[u] += s[v];
            s[v] = u;
        } else {
            s[v] += s[u];
            s[u] = v;
        }

        return true;
    }

    private static int find(int u, int[] s) {
        return s[u] < 0 ? u : (s[u] = find(s[u], s));
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
