package boj17626;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();

        int[] dp = new int[N + 1];

        dp[1] = 1;

        int min, diff;
        for (int i = 2; i <= N; i++) {
            min = 5;
            for (int j = 1; j * j <= i; j++) {
                diff = i - j * j;
                if (min > dp[diff]) min = dp[diff];
            }
            dp[i] = min + 1;
        }

        System.out.print(dp[N]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
