package boj7662;

import java.util.PriorityQueue;

class Node {
    int v;
    int i;
    Node(int v, int i) {
        this.v = v;
        this.i = i;
    }
}

class Main {

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.v > b.v ? 1 : -1);
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> a.v > b.v ? -1 : 1);
        boolean[] visited = new boolean[1_000_001];

        while (T --> 0) {
            minHeap.clear();
            maxHeap.clear();

            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                boolean op = in.nextOp();
                int x = in.nextInt();
                if (op) {
                    if (x < 0) {
                        while (!minHeap.isEmpty() && !visited[minHeap.peek().i]) minHeap.poll();
                        if (!minHeap.isEmpty()) visited[minHeap.poll().i] = false;
                    } else {
                        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().i]) maxHeap.poll();
                        if (!maxHeap.isEmpty()) visited[maxHeap.poll().i] = false;
                    }
                } else {
                    minHeap.offer(new Node(x, i));
                    maxHeap.offer(new Node(x, i));
                    visited[i] = true;
                }
            }

            while (!minHeap.isEmpty() && !visited[minHeap.peek().i]) minHeap.poll();
            while (!maxHeap.isEmpty() && !visited[maxHeap.peek().i]) maxHeap.poll();

            if (minHeap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(maxHeap.poll().v).append(' ').append(minHeap.poll().v);
            }
            sb.append('\n');

        }

        System.out.print(sb);

    }

}

class Reader {

    private final int BUFFER_SIZE = 1 << 10;
    private int bufferIndex, bufferSize;
    byte[] buffer;

    Reader() {
        buffer = new byte[BUFFER_SIZE];
        bufferIndex = bufferSize = 0;
    }

    boolean nextOp() throws Exception {
        byte c;
        while ((c = read()) <= 32);
        return c == 68;
    }

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);

        boolean isPositive = isNumber(c);
        if (!isPositive) c = read();

        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));

        return isPositive ? n : ~n + 1;
    }

    private boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    private byte read() throws Exception {
        if (bufferIndex == bufferSize) {
            bufferSize = System.in.read(buffer, bufferIndex = 0, BUFFER_SIZE);
            if (bufferSize < 0) buffer[0] = -1;
        }
        return buffer[bufferIndex++];
    }

}
