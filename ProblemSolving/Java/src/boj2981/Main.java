package boj2981;

import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        getFactors(gcd(getList(read())))
            .stream()
            .sorted()
            .forEach(v -> sb.append(v).append(' '));
        System.out.print(sb);

    }

    static Set<Integer> getFactors(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        set.add(n);
        return set;
    }

    static int gcd(List<Integer> list) {
        int gcd = list.get(0);
        int size = list.size();

        for (int i = 1; i < size; i++)
            gcd = gcd(gcd, list.get(i));

        return gcd;
    }

    static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }

    static List<Integer> getList(int size) throws Exception {

        int[] input = new int[size];
        for (int i = 0; i < size; i++) input[i] = read();
        Arrays.sort(input);

        List<Integer> list = new ArrayList<>(size - 1);
        for (int i = 1; i < size; i++)
            list.add(input[i] - input[i - 1]);

        return list;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
