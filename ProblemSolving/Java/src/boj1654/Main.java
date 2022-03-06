package boj1654;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {

        int K = read();
        int N = read();

        List<Integer> lines = new ArrayList<>(K);
        for (int i = 0; i < K; i++) lines.add(read());
        Collections.sort(lines);

        long l = 0;
        long r = lines.get(K - 1);

        while (l < r) {
            long m = l + r + 1 >> 1;
            long s = 0;
            for(Integer line : lines) s += line / m;

            if (s < N) r = m - 1;
            else l = m;
        }

        System.out.print(r);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
