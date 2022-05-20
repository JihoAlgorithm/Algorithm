package boj11049;

class Main {

    static final int INF = -1 >>> 1;

    public static void main(String[] args) throws Exception {

        int N = read();
        int[][] matrix = new int[N + 1][2];
        int[][] dp = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            matrix[i][0] = read();
            matrix[i][1] = read();
        }

        for (int i = 1; i < N; i++) {
            for (int s = 1; i + s <= N; s++) {
                int e = i + s;
                dp[s][e] = INF;
                for (int k = s; k <= e; k++) {
                    dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k + 1][e] + matrix[s][0] * matrix[k][1] * matrix[e][1]);
                }
            }
        }

        System.out.print(dp[1][N]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
