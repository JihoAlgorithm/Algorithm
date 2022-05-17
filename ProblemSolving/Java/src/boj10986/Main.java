package boj10986;

class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {

        N = next();
        M = next();

        int prefixSum = 0;
        long[] cnt = new long[M];
        for (int i = 0; i < N; i++) {
            prefixSum = (prefixSum + next()) % M;
            cnt[prefixSum]++;
        }

        long count = cnt[0];

        for (int i = 0; i < M; i++) {
            count += (cnt[i] * (cnt[i] - 1)) >> 1;
        }

        System.out.print(count);

    }

    static final int SIZE = 1 << 13;
    static byte[] buffer = new byte[SIZE];
    static int index, size;

    static int next() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 47 && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

}
