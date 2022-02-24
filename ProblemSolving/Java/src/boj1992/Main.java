package boj1992;

class Main {

    static boolean[][] frame;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        int N = read();
        frame = new boolean[N][N];
        sb = new StringBuilder();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                frame[r][c] = System.in.read() == 49;
            }
            System.in.read();
        }
        compress(0, 0, N);
        System.out.println(sb);
    }

    static void compress(int R, int C, int size) {
        boolean offset;
        int rEnd, cEnd, count = size * size;

        offset = frame[R][C];
        rEnd = R + size;
        cEnd = C + size;

        outer:
            for (int r = R; r < rEnd; r++) {
                for (int c = C; c < cEnd; c++) {
                    if (offset != frame[r][c]) {
                        int s = size >> 1;
                        sb.append('(');
                        compress(R, C, s);
                        compress(R, C + s, s);
                        compress(R + s, C, s);
                        compress(R + s, C + s, s);
                        sb.append(')');
                        break outer;
                    }
                    count--;
                }
            }

        if (count == 0) sb.append(offset ? 1 : 0);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
