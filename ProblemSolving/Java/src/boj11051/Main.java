package boj11051;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(nCk(read(), read()));
    }

    static int nCk(int N, int K) {
        int[][] triangle = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) triangle[i][0] = triangle[i][i] = 1;

        for (int n = 2; n <= N; n++)
            for (int k = 1; k < n; k++)
                triangle[n][k] = (triangle[n - 1][k] + triangle[n - 1][k - 1]) % 10007;

        return triangle[N][K];
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
