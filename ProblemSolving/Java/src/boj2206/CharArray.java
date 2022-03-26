package boj2206;

import java.util.ArrayDeque;

class CharArray {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        char[][] map = new char[N][M];

        try (
            java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
            java.io.BufferedReader br = new java.io.BufferedReader(isr);
        ) {
            for (int i = 0; i < N; i++)
                map[i] = br.readLine().toCharArray();
        } catch (Exception e) {}

        System.out.println(bfs(N, M, map));

    }

    static final int[] dn = { -1, 1, 0, 0 };
    static final int[] dm = { 0, 0, -1, 1 };

    static int bfs(int N, int M, char[][] map) {

        int count = 1;
        ArrayDeque<Coord> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];

        visited[0][0][0] = visited[0][0][1] = true;
        queue.offer(new Coord(0, 0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Coord coord = queue.poll();
                if (coord.n + 1 == N && coord.m + 1 == M) return count;
                for (int i = 0; i < 4; i++) {
                    int nn = coord.n + dn[i];
                    int nm = coord.m + dm[i];
                    int nw = coord.w;

                    if (nn < 0 || nm < 0 || nn == N || nm == M) continue;
                    if (visited[nn][nm][nw]) continue;
                    visited[nn][nm][nw] = true;

                    if (map[nn][nm] == '1')
                        if (nw == 1) continue;
                        else nw = 1;

                    queue.offer(new Coord(nn, nm, nw));
                }
            }
            count++;
        }

        return -1;
    }

    static class Coord {
        int n;
        int m;
        int w;
        Coord(int n, int m, int w) {
            this.n = n;
            this.m = m;
            this.w = w;
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
