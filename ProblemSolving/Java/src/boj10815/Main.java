package boj10815;

import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        Set<Integer> cards = new HashSet<>(N);
        while (N-- > 0) cards.add(read());

        int M = read();
        StringBuilder sb = new StringBuilder();
        while (M -- > 0) sb.append(cards.contains(read()) ? 1 : 0).append(' ');

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
