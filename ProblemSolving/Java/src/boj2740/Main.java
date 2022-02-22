package boj2740;

class Main {

    public static void main(String[] args) throws Exception {
        int N, M, K;
        N = read();
        M = read();
        int[][] matrixA = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                matrixA[n][m] = read();
            }
        }
        M = read();
        K = read();
        int[][] matrixB = new int[M][K];
        for (int m = 0; m < M; m++) {
            for (int k = 0; k < K; k++) {
                matrixB[m][k] = read();
            }
        }
        int[][] matrixC = new int[N][K];
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                for (int m = 0; m < M; m++) {
                    matrixC[n][k] += matrixA[n][m] * matrixB[m][k];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                sb.append(matrixC[n][k]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
