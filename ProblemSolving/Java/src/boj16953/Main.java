package boj16953;

import java.util.ArrayDeque;

class Main {

    public static void main(String[] args) throws Exception {

        int A = read();
        int B = read();
        System.out.println(bfs(A, B));

    }

    static int bfs(long A, long B) {

        int times = 0;

        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            times++;

            int size = queue.size();

            while (size-- > 0) {
                long t, n = queue.poll();
                if (n == B) return times;

                t = n << 1;
                if (t <= B) queue.offer(t);
                t = (n << 3) + (n << 1) + 1;
                if (t <= B) queue.offer(t);
            }
        }

        return -1;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
