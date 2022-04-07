package boj11723;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Main {

    static final int ADD = 144;
    static final int REMOVE = 264565;
    static final int CHECK = 38541;
    static final int TOGGLE = 557825;
    static final int ALL = 232;
    static final int EMPTY = 63049;

    static final int MASK = (1 << 21) - 1;

    public static void main(String[] args) throws Exception {

        int M = read();

        int SIZE = 8192;
        int top = 0;
        char[] buffer = new char[SIZE];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int set = 0;

        while (M-- > 0) {

            switch (read()) {
            case ADD:
                set |= 1 << read();
                break;
            case REMOVE:
                set &= ~(1 << read());
                break;
            case CHECK:
                buffer[top++] = (set & (1 << read())) != 0 ? '1' : '0';
                buffer[top++] = '\n';
                if (top == SIZE) {
                    bw.write(buffer);
                    top = 0;
                }
                break;
            case TOGGLE:
                set ^= 1 << read();
                break;
            case ALL:
                set = MASK;
                break;
            case EMPTY:
                set = 0;
                break;
            }

        }

        bw.write(buffer, 0, top);
        bw.close();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
