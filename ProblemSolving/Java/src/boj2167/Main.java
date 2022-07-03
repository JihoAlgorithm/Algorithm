package boj2167;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int N = nextInt();
        int M = nextInt();

        int[][] matrix = new int[N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                matrix[r][c] = matrix[r - 1][c] + matrix[r][c - 1] - matrix[r - 1][c -  1] + nextInt();
            }
        }

        int K = nextInt();

        while (K-- > 0) {
            int i = nextInt();
            int j = nextInt();
            int x = nextInt();
            int y = nextInt();

            sb
                .append(matrix[x][y] - matrix[i - 1][y] - matrix[x][j - 1] + matrix[i - 1][j - 1])
                .append('\n');
        }

        System.out.print(sb);

    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        boolean isNegative = c == '-';
        if (isNegative) c = read();
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return isNegative ? ~n + 1 : n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
