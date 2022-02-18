package boj18258;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class QueueImplementBuffer {

    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] queue = new int[N];
        int tail, head;
        tail = head = 0;

        initWriter();

        while (N-- > 0) {
            int op = System.in.read();
            if (op == 'p') op = System.in.read();
            read();
            switch (op) {
                case 'u':
                    queue[tail++] = read();
                    continue;
                case 'o':
                    write(tail == head ? -1 : queue[head++]);
                    break;
                case 's':
                    write(tail - head);
                    break;
                case 'e':
                    write(tail == head ? 1 : 0);
                    break;
                case 'f':
                    write(tail == head ? -1 : queue[head]);
                    break;
                case 'b':
                    write(tail == head ? -1 : queue[tail - 1]);
                    break;
            }
        }

        flush();
        bw.close();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static char[] buffer;
    static char[] temp;
    static int pointer;
    static final int MAX_SIZE = 512;

    static void initWriter() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        buffer = new char[MAX_SIZE];
        temp = new char[8];
    }

    static void write(int num) throws Exception {
        if (pointer + 8 >= MAX_SIZE) flush();
        if (num < 0) {
            buffer[pointer++] = 45;
            buffer[pointer++] = 49;
        } else {
            int p = 0;
            do {
                temp[p++] = (char) ((num % 10) | 48);
            } while ((num /= 10) > 0);
            while (p > 0) buffer[pointer++] = temp[--p];
        }
        buffer[pointer++] = 10;
    }

    static void flush() throws Exception {
        bw.write(buffer, 0, pointer);
        pointer = 0;
    }

}
