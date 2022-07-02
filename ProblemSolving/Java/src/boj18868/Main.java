package boj18868;

class Main {

    static int M, N;
    static int[][] universe;

    public static void main(String[] args) throws Exception {

        M = nextInt();
        N = nextInt();

        universe = new int[M][N];
        int balance = 0;

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                universe[m][n] = nextInt();
            }
        }

        for (int m1 = 0; m1 < M; m1++) {
            for (int m2 = m1 + 1; m2 < M; m2++) {
                balance += isBalaced(m1, m2);
            }
        }

        System.out.print(balance);

    }

    static int isBalaced(int m1, int m2) {
        for (int a = 0; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                int diff1 = universe[m1][a] - universe[m1][b];
                int diff2 = universe[m2][a] - universe[m2][b];

                if (diff1 < 0 && diff2 >= 0) return 0;
                if (diff1 > 0 && diff2 <= 0) return 0;
                if (diff1 == 0 && diff2 != 0) return 0;
            }
        }
        return 1;
    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
