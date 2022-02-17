package boj17298;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class NoStackBuffer {

    public static void main(String[] args) throws Exception {

        int N = read();
        int top = N;
        int[] input = new int[N];

        final int MAX_INDEX = 1_000_000 << 3;
        int pointer = MAX_INDEX;
        char[] buffer = new char[pointer];

        for (int i = 0; i < N; i++) input[i] = read();

        for (int i = N; i-- > 0;) {
            while (top < N && input[top] <= input[i]) top++;
            if (top >= N) {
                buffer[--pointer] = 49;
                buffer[--pointer] = 45;
            } else {
                int num = input[top];
                do {
                    buffer[--pointer] = (char) (num % 10 + 48);
                } while ((num /= 10) > 0);
            }
            buffer[--pointer] = 32;
            input[--top] = input[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(buffer, ++pointer, MAX_INDEX - pointer);
        bw.close();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
