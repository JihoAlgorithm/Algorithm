package boj1697;

import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node node = new Node(N, 0);
        pq.offer(node);

        boolean[] visited = new boolean[100_001];

        while (pq.peek().x != K) {
            node = pq.poll();
            if (node.x < 0 || node.x > 100_000) continue;
            if (visited[node.x]) continue;
            visited[node.x] = true;
            pq.offer(new Node(node.x - 1, node.t + 1));
            pq.offer(new Node(node.x + 1, node.t + 1));
            pq.offer(new Node(node.x << 1, node.t + 1));
        }

        System.out.print(pq.peek().t);

    }

    static class Node implements Comparable<Node> {
        int x;
        int t;
        Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
