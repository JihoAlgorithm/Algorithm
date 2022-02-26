package boj10830;

class Main {

    static int N;
    static int[][] matrix;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        N = read();
        long B = readL();
        int[][] A = new int[N][N];
        matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                A[r][c] = read() % MOD;
            }
        }
        matrix = pow(A, B);
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(matrix[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] A, long B) {
        if (B == 1) return A;
        matrix = pow(A, B >> 1);
        matrix = multiply(matrix, matrix);
        if ((B & 1) == 1) matrix = multiply(matrix, A);
        return matrix;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = 0; k < N; k++) {
                    result[r][c] += a[r][k] * b[k][c];
                }
                result[r][c] %= MOD;
            }
        }
        return result;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static long readL() throws Exception {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
