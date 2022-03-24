package boj7562;

import java.util.LinkedList;

class Main {

    static final int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int BIT = 9, MASK = (1 << BIT) - 1;

    public static void main(String[] args) throws Exception {

        int T = read();
        LinkedList<Integer> pq = new LinkedList<>();
        BinaryVisited bv[] =  new BinaryVisited[300];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 300; i++) bv[i] = new BinaryVisited(300);

        while (T-- > 0) {

            int I = read();

            int node = 0;
            int time = 0;
            int r = read();
            int c = read();
            final int er = read();
            final int ec = read();

            pq.offer(bind(0, r, c));

            while (!pq.isEmpty()) {

                node = pq.poll();
                time = node >> BIT >> BIT;
                r = (node >> BIT) & MASK;
                c = node & MASK;

                if (r == er && c == ec) break;

                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= I || nc >= I || bv[nr].isVisited(nc)) continue;

                    bv[nr].visit(nc);
                    pq.offer(bind(time + 1, nr, nc));
                }

            }

            sb.append(time).append('\n');
            pq.clear();
            for (int i = 0; i < I; i++) bv[i].clear();

        }

        System.out.print(sb);

    }

    static int bind(int t, int r, int c) {
        return (t << BIT | r) << BIT | c;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class BinaryVisited {

    static final int BIT = 5;
    static final int MASK = 31;

    int[] visited;

    BinaryVisited(int size) {
        visited = new int[(size >> BIT) + 1];
    }

    void visit(int node) {
        visited[node >> BIT] |= 1 << (node & MASK);
    }

    boolean isVisited(int node) {
        return ((visited[node >> BIT] >> (node & MASK)) & 1) == 1;
    }

    void clear() {
        for (int i = 0; i < visited.length; i++) visited[i] = 0;
    }

}
