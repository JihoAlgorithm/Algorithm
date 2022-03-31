package boj13549;

class ZeroOneBFS {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        if (N >= K) {
            System.out.print(N - K);
            return;
        }

        int time = 0;

        final int MASK = (1 << 14) - 1;
        int i = 0;
        int[] head = new int[2];
        int[] tail = new int[2];
        int[][] queue = new int[2][MASK + 1];

        final int MAX = K + 1;
        final int VB = 5;
        final int VM = 31;
        int[] visited = new int[(MAX >> VB) + 1];

        visited[N >> VB] |= 1 << (N & VM);
        queue[i][++tail[i]] = N;

        while (head[i] < tail[i]) {

            int x, cx = queue[i][++head[i] & MASK];

            if (cx == K) {
                System.out.print(time);
                break;
            }

            x = cx << 1;
            if (x <= MAX && ((visited[x >> VB] >> (x & VM)) & 1) == 0) {
                visited[x >> VB] |= 1 << (x & VM);
                queue[i][++tail[i] & MASK] = x;
            }

            x = cx - 1;
            if (x >= 0 && ((visited[x >> VB] >> (x & VM)) & 1) == 0) {
                visited[x >> VB] |= 1 << (x & VM);
                queue[i ^ 1][++tail[i ^ 1] & MASK] = x;
            }

            x = cx + 1;
            if (x <= MAX && ((visited[x >> VB] >> (x & VM)) & 1) == 0) {
                visited[x >> VB] |= 1 << (x & VM);
                queue[i ^ 1][++tail[i ^ 1] & MASK] = x;
            }

            if (head[i] == tail[i]) {
                i ^= 1;
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
