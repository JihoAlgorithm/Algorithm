package boj1037;

class Radix {

    public static void main(String[] args) throws Exception {

        int size = read();
        int[] factor = getFactors(size);

        int N = 0;
        if ((size & 1) == 0)
            N = factor[0] * factor[size - 1];
        else
            N = (int) Math.pow(factor[size >> 1], 2);

        print(N);

    }

    static int[] getFactors(int size) throws Exception {

        int[] factor = new int[size];

        int max = 0;
        for (int i = 0; i < size; i++) {
            factor[i] = read();
            if (max < factor[i]) max = factor[i];
        }

        sort(factor, (int) Math.log10(max) + 1);

        return factor;

    }

    static void sort(int[] a, int round) {

        Queue[] bucket = new Queue[10];
        for (int i = 0; i < 10; i++) bucket[i] = new Queue();

        int ten = 1;
        int len = a.length;

        while (round-- > 0) {

            for (int i = 0; i < len; i++)
                bucket[a[i] / ten % 10].offer(a[i]);

            int idx = 0;
            for (int i = 0; i < 10; i++)
                while (!bucket[i].isEmpty())
                    a[idx++] = bucket[i].poll();

            ten = (ten << 3) + (ten << 1);

        }

    }

    static void print(int N) {
        try (
            java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(System.out);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(osw);
        ) {
            int len = (int) Math.log10(N) + 1;
            char[] buffer = new char[len];

            while (N > 0) {
                buffer[--len] = (char) (N % 10 | 48);
                N /= 10;
            }

            bw.write(buffer);
        } catch (Exception e) {}
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Queue {

    final int MASK = 63;

    int[] queue;
    int head;
    int tail;

    Queue() {
        queue = new int[MASK + 1];
        head = tail = -1;
    }

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
