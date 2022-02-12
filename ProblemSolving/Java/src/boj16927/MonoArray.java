package boj16927;

class MonoArray {

    static int N, M, R, layers;
    static int[][] array;
    static int[] line;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        R = read();

        layers = (N < M ? N : M) >> 1;
        line = new int[((N + M) << 1) - 4];
        array = new int[N][M];

        for (int n = 0; n < N; n++) for (int m = 0; m < M; m++) array[n][m] = read();

        for (int layer = 0; layer < layers; layer++) {
            int r, c;
            int i = 0;
            int circum = (N + M - 2 - (layer << 2)) << 1;
            int round = R % circum;

            i = 0;
            r = c = layer;
            line[i++] = array[r][c];

            for (int d = 0; d < 4; d++) {
                while (true) {
                    r += dr[d];
                    c += dc[d];
                    if (isOut(r, c, layer)) {
                        r -= dr[d];
                        c -= dc[d];
                        break;
                    }
                    line[i++] = array[r][c];
                }
            }

            i = 0;
            r = c = layer;
            array[r][c] = line[(i++ + round) % circum];

            for (int d = 0; d < 4; d++) {
                while (true) {
                    r += dr[d];
                    c += dc[d];
                    if (isOut(r, c, layer)) {
                        r -= dr[d];
                        c -= dc[d];
                        break;
                    }
                    array[r][c] = line[(i++ + round) % circum];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++)
                sb.append(array[n][m]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static boolean isOut(int n, int m, int l) {
        return n < l || n + l == N || m < l || m + l == M || (n == l && m == l);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
