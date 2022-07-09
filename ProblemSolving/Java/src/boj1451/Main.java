package boj1451;

class Main {

    static int[][] rectangle;
    static int N, M;
    static long p, q, r, max;

    public static void main(String[] args) throws Exception {
        ready();
        sliceHorizontally();
        sliceVertically();
        sliceHorizontalTopDowm();
        sliceVerticalLeftRight();
        System.out.print(max);
    }

    static void sliceHorizontally() {
        if (N < 3) return;
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j <= N - i; j++) {
                p = getSum(1, 1, i, M);
                q = getSum(i + 1, 1, j, M);
                r = getSum(j + 1, 1, N, M);
                max = Math.max(max, p * q * r);
            }
        }
    }

    static void sliceVertically() {
        if (M < 3) return;
        for (int i = 1; i < M - 1; i++) {
            for (int j = i + 1; j <= M - i; j++) {
                p = getSum(1, 1, N, i);
                q = getSum(1, i + 1, N, j);
                r = getSum(1, j + 1, N, M);
                max = Math.max(max, p * q * r);
            }
        }
    }

    static void sliceHorizontalTopDowm() {
        if (N < 2 || M < 2)	return;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                p = getSum(1, 1, i, j);
                q = getSum(1, j + 1, i, M);
                r = getSum(i + 1, 1, N, M);
                max = Math.max(max, p * q * r);
                p = getSum(1, 1, i, M);
                q = getSum(i + 1, 1, N, j);
                r = getSum(i + 1, j + 1, N, M);
                max = Math.max(max, p * q * r);
            }
        }
    }

    static void sliceVerticalLeftRight() {
        if (N < 2 || M < 2)	return;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                p = getSum(1, 1, i, j);
                q = getSum(i + 1, 1, N, j);
                r = getSum(1, j + 1, N, M);
                max = Math.max(max, p * q * r);
                p = getSum(1, 1, N, j);
                q = getSum(1, j + 1, i, M);
                r = getSum(i + 1, j + 1, N, M);
                max = Math.max(max, p * q * r);
            }
        }
    }

    static int getSum(int si, int sj, int ei, int ej) {
        return rectangle[ei][ej]
            - rectangle[si - 1][ej]
            - rectangle[ei][sj - 1]
            + rectangle[si - 1][sj - 1];
    }

    static void ready() throws Exception {
        N = read();
        M = read();

        byte[][] buffer = new byte[N + 1][M + 2];
        rectangle = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            System.in.read(buffer[i], 1, M + 1);
            for (int j = 1; j <= M; j++) {
                rectangle[i][j] = (buffer[i][j] & 15)
                    + rectangle[i - 1][j]
                    + rectangle[i][j - 1]
                    - rectangle[i - 1][j - 1];
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
