package boj15666;

class Main {

    static int N, M;
    static StringBuilder sb;
    static int[] num, seq, prev;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        sb = new StringBuilder();
        num = new int[N];
        seq = new int[M];
        prev = new int[M];

        for (int i = 0; i < N; i++) num[i] = read();
        java.util.Arrays.sort(num);

        dfs(0, 0);

        System.out.print(sb);

    }

    static void dfs(int cnt, int idx) {

        if (cnt == M) {
            boolean isPossible = true;
            for (int i = 0; i < M; i++) {
                if (prev[i] < seq[i]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) return;

            copy();

            for (int i = 1; i < M; i++) {
                sb.append(seq[i - 1]).append(' ');
            }
            sb.append(seq[M - 1]).append('\n');

            return;
        }

        for (int i = idx; i < N; i++) {
            seq[cnt] = num[i];
            dfs(cnt + 1, i);
        }

    }

    static void copy() {
        for (int i = 0; i < M; i++) {
            prev[i] = seq[i];
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
