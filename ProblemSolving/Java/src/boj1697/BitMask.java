package boj1697;

import java.util.PriorityQueue;

class BitMask {

    static final int BIT = 18;
    static final int MASK = (1 << BIT) - 1;

    public static void main(String[] args) throws Exception {

        long N = read();
        int K = read();

        if (N >= K) {
            System.out.print(N - K);
            return;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(N);

        boolean[] visited = new boolean[100_001];

        while ((pq.peek() & MASK) != K) {
            long x = pq.peek() & MASK;
            long t = pq.poll() >> BIT;

            if (x < 0 || x > 100_000 || visited[(int) x]) continue;
            visited[(int) x] = true;

            pq.offer(x - 1 | (t + 1) << BIT);
            pq.offer(x + 1 | (t + 1) << BIT);
            pq.offer(x << 1 | (t + 1) << BIT);
        }

        System.out.print(pq.peek() >> BIT);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
