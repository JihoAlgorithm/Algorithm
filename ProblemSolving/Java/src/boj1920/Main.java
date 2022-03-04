package boj1920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        int N = read();
        list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) list.add(read());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        int M = read();
        while (M-- > 0) sb.append(binarySearch(read())).append('\n');

        System.out.print(sb);
    }

    static int binarySearch(int key) {
        int l = 0;
        int r = list.size();
        int m;

        while (l < r) {
            m = l + r >> 1;
            int n = list.get(m);
            if (n == key) return 1;
            if (n < key) l = m + 1;
            else r = m;
        }

        return 0;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
