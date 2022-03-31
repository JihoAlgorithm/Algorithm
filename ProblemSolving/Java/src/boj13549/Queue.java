package boj13549;

class Queue {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        if (N >= K) {
            System.out.print(N - K);
            return;
        }

        int time = 0;

        int head0 = -1;
        int tail0 = -1;
        int head1 = -1;
        int tail1 = -1;
        final int MASK = (1 << 14) - 1;

        int[] q0 = new int[MASK + 1];
        int[] q1 = new int[MASK + 1];
        int[] qt = null;

        final int MAX = K + 1;
        boolean[] visited = new boolean[MAX + 1];

        visited[N] = true;
        q0[++tail0] = N;

        while (head0 < tail0) {

            int x, cx = q0[++head0 & MASK];

            if (cx == K) {
                System.out.print(time);
                break;
            }

            x = cx << 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                q0[++tail0 & MASK] = x;
            }

            x = cx - 1;
            if (x >= 0 && !visited[x]) {
                visited[x] = true;
                q1[++tail1 & MASK] = x;
            }

            x = cx + 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                q1[++tail1 & MASK] = x;
            }

            if (head0 == tail0) {
                qt = q0;
                q0 = q1;
                q1 = qt;

                head0 = head1;
                head1 = tail0;
                tail0 = tail1;
                tail1 = head1;

                time++;
            }

        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
