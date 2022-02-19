package boj2164;

import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.offer(i);
        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.print(queue.poll());
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
