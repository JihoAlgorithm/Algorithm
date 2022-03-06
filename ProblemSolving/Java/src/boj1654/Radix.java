package boj1654;

class Radix {

    public static void main(String[] args) throws Exception {

        int K = read();
        int N = read();
        int[] lines = getSortedLines(K);

        long l, m, r;
        l = 1;
        r = lines[K - 1];

        while (l <= r) {
            m = l + r >> 1;
            int s = 0;
            for (int i = 0; i < K; i++) s += lines[i] / m;
            if (s < N)
                r = m - 1;
            else
                l = m + 1;
        }

        System.out.print(r);

    }

    static int[] getSortedLines(int size) throws Exception {

        int max = 0;
        int[] lines = new int[size];
        for (int i = 0; i < size; i++) {
            lines[i] = read();
            if (max < lines[i]) max = lines[i];
        }

        radixSort(lines, (int) Math.log10(max) + 1);

        return lines;

    }

    static void radixSort(int[] lines, int round) {

        Queue[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) buckets[i] = new Queue();

        int ten = 1;
        int idx = 0;
        int len = lines.length;

        while (round-- > 0) {

            for (int i = 0; i < len; i++)
                buckets[lines[i] / ten % 10].offer(lines[i]);

            for (int i = 0; i < 10; i++)
                while (!buckets[i].isEmpty())
                    lines[idx++] = buckets[i].poll();

            ten = (ten << 3) + (ten << 1);
            idx = 0;

        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Queue {

    int head = -1;
    int tail = -1;
    static final int MASK = (1 << 14) - 1;
    int[] queue = new int[MASK + 1];

    boolean isEmpty() {
        return head == tail;
    }

    void offer(int e) {
        queue[++tail & MASK] = e;
    }

    int poll() {
        return queue[++head & MASK];
    }

}
