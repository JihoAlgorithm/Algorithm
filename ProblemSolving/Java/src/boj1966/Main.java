package boj1966;

class Main {

    static Bucket[] buckets;
    static int N, M;

    public static void main(String[] args) throws Exception {
        int T = read();
        buckets = new Bucket[10];
        for (int i = 1; i < 10; i++) buckets[i] = new Bucket();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            ready();
            sb.append(count()).append('\n');
        }

        System.out.print(sb);

    }

    static int count() {

        int result = 1;
        int i = 10;
        Bucket prevBucket = buckets[0];

        while (i-- > 0) {
            if (buckets[i].isEmpty()) continue;
            for (int j = 0; j < buckets[i].size(); j++)
                if (buckets[i].get(j) == M) return j + 1;
            prevBucket = buckets[i];
            break;
        }

        result += prevBucket.size();

        while (i-- > 0) {
            Bucket bucket = buckets[i];
            if (buckets[i].isEmpty()) continue;
            int key = prevBucket.peekLast();
            int pivot = upperBound(key, bucket);

            for (int j = 0; j < pivot; j++) bucket.offer(bucket.poll());
            for (int j = 0; j < bucket.size(); j++)
                if (bucket.get(j) == M) return result + j;

            prevBucket = bucket;
            result += bucket.size();

        }

        return -1;

    }

    static int upperBound(int key, Bucket bucket) {
        int l = 0;
        int r = bucket.size();
        int m;
        while (l < r)
            if (bucket.get(m = l + r >> 1) > key) r = m;
            else l = m + 1;
        return r;
    }

    static void ready() throws Exception {
        N = read();
        M = read();
        for (int i = 1; i < 10; i++) buckets[i].init();
        fillBuckets();
    }

    static void fillBuckets() throws Exception {
        for (int i = 0; i < N; i++) {
            int priority = read();
            buckets[priority].offer(i);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Bucket {
    int[] queue;
    int head;
    int tail;
    int mask;
    Bucket() {
        mask = 127;
        queue = new int[128];
    }
    void init() {
        head = 0;
        tail = 0;
    }
    int size() {
        return tail - head;
    }
    boolean isEmpty() {
        return tail == head;
    }
    void offer(int num) {
        queue[tail++ & mask] = num;
    }
    int poll() {
        return queue[head++ & mask];
    }
    int get(int index) {
        return queue[head + index & mask];
    }
    int peekLast() {
        return queue[tail - 1 & mask];
    }
}
