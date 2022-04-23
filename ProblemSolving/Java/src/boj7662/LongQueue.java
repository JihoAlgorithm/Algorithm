package boj7662;

class LongQueue {

    static final String EMPTY = "EMPTY";
    static final boolean[] visited = new boolean[1_000_001];

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();

        while (T-- > 0) {
            minHeap.clear();
            maxHeap.clear();

            int Q = in.nextInt();

            for (int i = 0; i < Q; i++) {
                boolean op = in.nextOp();
                int x = in.nextInt();

                if (op) {
                    if (x < 0) {
                        poll(minHeap);
                    } else {
                        poll(maxHeap);
                    }
                } else {
                    minHeap.offer(x, i);
                    maxHeap.offer(x, i);
                    visited[i] = true;
                }
            }

            cleanUp(minHeap);
            cleanUp(maxHeap);

            if (minHeap.isEmpty()) {
                sb.append(EMPTY);
            } else {
                sb.append(maxHeap.value()).append(' ').append(minHeap.value());
            }
            sb.append('\n');

        }

        System.out.print(sb);

    }

    static void cleanUp(Heap heap) {
        while (!heap.isEmpty() && !visited[heap.index()]) heap.poll();
    }

    static void poll(Heap heap) {
        cleanUp(heap);
        if (!heap.isEmpty()) {
            visited[heap.index()] = false;
            heap.poll();
        }
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

class Heap {

    private final int MAX_SIZE = 1 << 20;
    private final int BIT = 20;
    private final int MASK = (1 << BIT) - 1;

    private long[] heap;
    private int size;

    Heap() {
        size = 0;
        heap = new long[MAX_SIZE];
    }

    void clear() {
        size = 0;
    }

    int index() {
        return (int) (heap[1] & MASK);
    }

    int value() {
        long value = heap[1];
        if (value < 0) {
            value ^= 1L << 63;
            value >>= BIT;
            return (int) (~value + 1);
        } else {
            return (int) (value >> BIT);
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    void offer(long value, int index) {
        if (value < 0) {
            value = ~value + 1;
            value |= 1L << (63 - BIT);
        }
        heap[++size] = (value << BIT) | index;

        int i = size << 1;

        while ((i >>= 1) > 1)
            if (!swap(i)) break;
    }

    void poll() {
        heap[1] = heap[size--];

        int i = 1;

        while ((i <<= 1) <= size) {
            if (i < size && compare(heap[i + 1], heap[i])) i++;
            if (!swap(i)) break;
        }
    }

    private boolean swap(int i) {
        int j = i >> 1;
        long p = heap[j];
        long c = heap[i];

        if (compare(p, c)) return false;

        heap[j] = c;
        heap[i] = p;

        return true;
    }

    boolean compare(long a, long b) {
        throw new Error();
    }

}

class MinHeap extends Heap {
    @Override
    boolean compare(long a, long b) {
        return a < 0 && b < 0 ? a > b : a < b;
    }
}

class MaxHeap extends Heap {
    @Override
    boolean compare(long a, long b) {
        return a < 0 && b < 0 ? a < b : a > b;
    }
}
