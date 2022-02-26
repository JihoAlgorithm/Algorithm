package boj10830;

class Buffer {

    static int N;
    static int[][] matrix;
    static final int MOD = 1000;

    static int pointer;
    static char[] buffer;

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

        buffer = new char[100];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                write(matrix[r][c]);
                buffer[pointer++] = 32;
            }
            buffer[pointer - 1] = 10;
        }
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        bw.write(buffer, 0, pointer);
        bw.close();
    }

    static void write(int num) {
        if (num == 0) {
            buffer[pointer++] = 48;
            return;
        }
        int i = pointer += (int) Math.log10(num) + 1;
        while (num > 0) {
            buffer[--i] = (char) (num % 10 | 48);
            num /= 10;
        }
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
