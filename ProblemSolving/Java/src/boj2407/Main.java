package boj2407;

class Main {

    static StringBuilder[][] dp;

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        dp = new StringBuilder[N + 1][M + 1];

        for (int i = 0; i <= N; i++)
            java.util.Arrays.fill(dp[i], new StringBuilder());

        combination(N, M);
        System.out.print(dp[N][M].reverse());
    }

    static StringBuilder combination(int n, int m) {
        if (n == m || m == 0) return new StringBuilder("1");
        if (dp[n][m].length() > 0) return dp[n][m];
        return dp[n][m] = add(combination(n - 1, m - 1), combination(n - 1, m));
    }

    static StringBuilder add(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();

        int aLen = a.length();
        int bLen = b.length();

        int sum = 0;
        int len = Math.max(aLen, bLen);

        for(int i=0; i < len || sum > 0; i++) {
            if (aLen > i) sum += a.charAt(i) & 15;
            if (bLen > i) sum += b.charAt(i) & 15;

            result.append(sum % 10);
            sum /= 10;
        }

        return result;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
