package boj1697;

import java.util.PriorityQueue;

class Array {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] node = new int[]{N, 0};
        pq.offer(node);

        boolean[] visited = new boolean[100_001];

        while (pq.peek()[0] != K) {
            node = pq.poll();
            if (node[0] < 0 || node[0] > 100_000) continue;
            if (visited[node[0]]) continue;
            visited[node[0]] = true;
            pq.offer(new int[]{node[0] - 1, node[1] + 1});
            pq.offer(new int[]{node[0] + 1, node[1] + 1});
            pq.offer(new int[]{node[0] << 1, node[1] + 1});
        }

        System.out.print(pq.peek()[1]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
