package boj10026;

import java.util.ArrayDeque;
import java.util.function.Function;

class Main {

    static int N;
    static final byte M = 60;
    static final byte R = 'R';
    static final byte G = 'G';
    static final byte B = 'B';

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        N = read();
        byte[][] screen = new byte[N][N + 1];
        boolean[][] visitedB = new boolean[N][N];
        boolean[][] visitedN = new boolean[N][N];
        final Function<Byte, Boolean> funcA = (a) -> (a & M) > 0;
        final Function<Byte, Boolean> funcB = (a) -> (a & M) == 0;
        int sectionB = 0;
        int sectionN = 0;

        for (int i = 0; i < N; i++) System.in.read(screen[i], 0, N + 1);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visitedN[r][c]) {
                    final byte s = screen[r][c];
                    bfs(r, c, screen, visitedN, a -> a == s);
                    sectionN++;
                }
                if (!visitedB[r][c]) {
                    bfs(r, c, screen, visitedB, screen[r][c] == 'B' ? funcB : funcA);
                    sectionB++;
                }
            }
        }

        System.out.print(
            new StringBuilder()
                .append(sectionN)
                .append(' ')
                .append(sectionB)
        );

    }

    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static int[] node;

    static void bfs(int r, int c, byte[][] screen, boolean[][] visited, Function<Byte, Boolean> func) {

        visited[r][c] = true;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            node = queue.poll();
            r = node[0];
            c = node[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr == N || nc == N || visited[nr][nc] || !func.apply(screen[nr][nc])) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
