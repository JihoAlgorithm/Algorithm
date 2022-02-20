package boj11866;

class DuckDuckGoose {

    static final java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static final char[] separator = { 44, 32 };
    
    static int N, K, head, tail;
    static int[] queue;
    static final int MASK = (1 << 10) - 1;

    public static void main(String[] args) throws Exception {

        N = read();
        K = read();

        queue = new int[MASK + 1];
        head = -1;
        tail = -1;
        for (int i = 1; i <= N; i++) queue[++tail] = i;

        playDuckDuckGoose();
        bw.close();

    }

    static void playDuckDuckGoose() throws Exception {
        bw.write(60);

        while (tail > head + 1) {
            for (int i = 1; i < K; i++)
                queue[++tail & MASK] = queue[++head & MASK];
            write(queue[++head & MASK]);
            bw.write(separator);
        }
        write(queue[++head & MASK]);

        bw.write(62);
    }

    static final int SIZE = 4;
    static char[] buffer = new char[SIZE];
    static void write(int number) throws Exception {
        int i = SIZE;
        while (number > 0) {
            buffer[--i] = (char) (number % 10 | 48);
            number /= 10;
        }
        bw.write(buffer, i, SIZE - i);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
