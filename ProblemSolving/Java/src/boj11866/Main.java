package boj11866;

import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws Exception {
        final String separator = ", ";
        int N = read();
        int K = read();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");
        for (int i = 1; i <= N; i++) queue.offer(i);
        while (queue.size() > 1) {
            for (int i = 1; i < K; i++) queue.offer(queue.poll());
            sb.append(queue.poll()).append(separator);
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
