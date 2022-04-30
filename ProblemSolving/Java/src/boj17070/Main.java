package boj17070;

class Main {

    static int N, ways;
    static boolean[][] map;

    static final int H = 0, V = 1, D = 2;

    public static void main(String[] args) throws Exception {

        N = read();
        map = new boolean[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (read() == 1) map[r][c] = true;
            }
        }

        dfs(1, 2, H);
        System.out.print(ways);

    }

    static final int[] dr = { 0, 1, 1 };
    static final int[] dc = { 1, 0, 1 };

    static void dfs(int r, int c, int dir) {
        if (isMovable(r, c)) return;
        if (r == N && c == N) {
            ways++;
            return;
        }

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (dir == D) {
            dfs(r, c + 1, H);
            dfs(r + 1, c, V);
        } else {
            dfs(nr, nc, dir);
        }

        boolean isMovable = true;
        for (int i = 0; i < 3; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (isMovable(nr, nc)) isMovable = false;
        }
        if (isMovable) dfs(nr, nc, D);
    }

    static boolean isMovable(int r, int c) {
        return r > N || c > N || map[r][c];
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
