package boj12851;

import java.util.ArrayDeque;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        final int MAX = Math.max(N, K) + 1;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[MAX + 1];

        int time = 0;
        int ways = 0;

        queue.offer(N);

        while (!queue.isEmpty()) {

            time++;
            int size = queue.size();

            ways = queue
                .stream()
                .filter(x -> x == K)
                .toArray()
                .length;

            if (ways > 0) break;

            while (size-- > 0) {

                int x = queue.poll();

                if (x < 0 || x > MAX || (0 < visited[x] && visited[x] < time)) continue;

                visited[x] = time;

                queue.offer(x - 1);
                queue.offer(x + 1);
                queue.offer(x << 1);

            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(time - 1).append('\n').append(ways);
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
