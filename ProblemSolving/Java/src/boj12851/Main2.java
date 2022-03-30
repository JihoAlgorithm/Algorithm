package boj12851;

class Main2 {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        if (N >= K) {
            System.out.println(N - K);
            System.out.print(1);
            return;
        }

        int time = 0;
        int ways = 0;

        final int MAX = Math.max(N, K) + 1;
        int[] visited = new int[MAX + 1];
        java.util.Arrays.fill(visited, MAX);

        final int MASK = (1 << 16) - 1;
        int[] queue = new int[MASK + 1];
        int head = -1;
        int tail = -1;

        queue[++tail] = N;

        while (head < tail) {

            time++;

            int size = tail - head;
            while (size-- > 0) {

                int x = queue[++head & MASK];

                x = x + 1;
                if (x <= MAX && time <= visited[x]) {
                    visited[x] = time;
                    queue[++tail & MASK] = x;
                }

                x = x - 2;
                if (x >= 0 && time <= visited[x]) {
                    visited[x] = time;
                    queue[++tail & MASK] = x;
                }

                x = (x + 1) << 1;
                if (x <= MAX && time <= visited[x]) {
                    visited[x] = time;
                    queue[++tail & MASK] = x;
                }

            }

            for (int i = head; i < tail;)
                if (queue[++i & MASK] == K) ways++;

            if (ways > 0) break;

        }

        System.out.println(time);
        System.out.print(ways);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
