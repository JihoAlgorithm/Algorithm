package boj7562;

import java.util.LinkedList;

class Normal {

    static final int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {

        int T = read();
        LinkedList<Coord> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        Coord coord;
        boolean[][] visited;

        while (T-- > 0) {

            int I = read();
            visited = new boolean[I][I];

            coord = new Coord(read(), read(), 0);
            final int er = read();
            final int ec = read();
            
            queue.offer(coord);

            while (!queue.isEmpty()) {
                coord = queue.poll();
                if (coord.r == er && coord.c == ec) break;
                for (int i = 0; i < 8; i++) {
                    int nr = coord.r + dr[i];
                    int nc = coord.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= I || nc >= I || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    queue.offer(new Coord(nr, nc, coord.time + 1));
                }
            }

            sb.append(coord.time).append('\n');
            queue.clear();

        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Coord {
    int r;
    int c;
    int time;
    Coord(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.time = t;
    }
}
