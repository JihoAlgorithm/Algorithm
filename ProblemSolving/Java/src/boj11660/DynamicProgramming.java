package boj11660;

class DynamicProgramming {

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt() + 1;
        int M = in.nextInt();

        int[][] dp = new int[N][N];

        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + in.nextInt();
            }
        }

        while (M-- > 0) {

            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            sb.append(dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1]).append('\n');

        }

        System.out.print(sb);

    }

}
