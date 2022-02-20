package boj11866;

class QueueImplement {

    static final java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static final int LT = 60, GT = 62, COMMA = 44, SPACE = 32;
    static final int MASK = (1 << 10) - 1;

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();
        int[] queue = new int[MASK + 1];
        int head = -1, tail = N - 1;
        for (int i = 0; i < N; i++) queue[i] = i + 1;

        bw.write(LT);

        while (tail > head + 1) {
            for (int i = 1; i < K; i++)
                queue[++tail & MASK] = queue[++head & MASK];
            write(queue[++head & MASK]);
            writeComma();
        }

        write(queue[++head & MASK]);
        bw.write(GT);
        bw.close();

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

    static void writeComma() throws Exception {
        bw.write(COMMA);
        bw.write(SPACE);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
