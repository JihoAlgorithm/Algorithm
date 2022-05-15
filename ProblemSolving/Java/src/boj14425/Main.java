package boj14425;

import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {

        int N = nextInt();
        int M = nextInt();

        Set<String> set = new HashSet<>();
        while (N-- > 0) set.add(next());

        int count = 0;
        while (M-- > 0) if (set.contains(next())) count++;

        System.out.print(count);

    }

    static final int SIZE = 1 << 13;
    static byte[] buffer = new byte[SIZE];
    static byte[] string = new byte[500];
    static int index, size;

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 47 && c < 58);
        return n;
    }

    static String next() throws Exception {
        while (read() <= 32);
        int i = 0;
        do string[i++] = buffer[index - 1];
        while (read() > 64);
        return new String(string, 0, i);
    }

    static byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

}
