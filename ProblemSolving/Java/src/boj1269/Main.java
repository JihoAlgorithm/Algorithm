package boj1269;

import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {

        Set<Integer> set = new HashSet<>();

        int A = nextInt();
        int B = nextInt();

        while (A-- > 0) set.add(nextInt());
        while (B-- > 0) {
            int e = nextInt();
            if (set.contains(e)) {
                set.remove(e);
            } else {
                set.add(e);
            }
        }

        System.out.print(set.size());

    }

    static final int SIZE = 1 << 13;
    static byte c, buffer[] = new byte[SIZE];
    static int index, size, n;

    static int nextInt() throws Exception {
        n = 0;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 32);
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
