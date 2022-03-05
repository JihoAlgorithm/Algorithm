package boj10816;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        List<Integer> deck = new ArrayList<>(N);
        for (int i = 0; i < N; i++) deck.add(read());
        deck.add(-10_000_001);
        deck.add(10_000_001);
        suffle(deck);
        StringBuilder sb = new StringBuilder();
        int M = read();
        while (M-- > 0) {
            int card = read();
            int ceil = upperBound(deck, card);
            int floor = lowerBound(deck, card);
            if (deck.get(floor) != card) {
                sb.append(0);
            } else {
                sb.append(ceil - floor);
            }
            sb.append(' ');
        }
        System.out.print(sb);
    }

    static int upperBound(List<Integer> deck, int card) {
        int l = 0;
        int r = deck.size();
        int m;

        while (l < r)
            if (deck.get(m = l + r >> 1) > card) r = m;
            else l = m + 1;

        return r;
    }

    static int lowerBound(List<Integer> deck, int card) {
        int l = 0;
        int r = deck.size();
        int m;

        while (l < r)
            if (deck.get(m = l + r >> 1) < card) l = m + 1;
            else r = m;

        return r;
    }

    static void suffle(List<Integer> deck) {
        Collections.sort(deck);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
