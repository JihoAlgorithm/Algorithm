package boj11866;

class BigBuffer {

    static final int MAX_LENGTH = 4894;
    static final char[] buffer = new char[MAX_LENGTH];
    static int pointer = 0;

    static int N, K, head = -1, tail = -1;
    static final int MASK = (1 << 10) - 1;
    static final char[] queue = new char[MASK + 1];

    public static void main(String[] args) throws Exception {

        N = read();
        K = read();
        for (char i = 1; i <= N; i++) queue[++tail] = i;

        playDuckDuckGoose();

        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        bw.write(buffer, 0, pointer);
        bw.close();

    }

    static void playDuckDuckGoose() throws Exception {
        buffer[pointer++] = 60;

        while (tail > head) {
            for (int i = 1; i < K; i++)
                queue[++tail & MASK] = queue[++head & MASK];
            write(queue[++head & MASK]);
            buffer[pointer++] = 44;
            buffer[pointer++] = 32;
        }
        pointer -= 2;

        buffer[pointer++] = 62;
    }

    static void write(int num) throws Exception {
        pointer += (int) Math.log10(num) + 1;
        int i = pointer;
        while (num > 0) {
            buffer[--i] = (char) (num % 10 | 48);
            num /= 10;
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
