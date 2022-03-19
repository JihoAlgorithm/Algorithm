package boj9375;

import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();
        Map<String, Integer> clothes = new HashMap<>();
        String clothe;

        while (T-- > 0) {

            int N = read();

            for (int c = 0; c < N; c++) {

                read();
                clothe = readClothe();

                int value = clothes.computeIfAbsent(clothe, k -> 1);
                clothes.put(clothe, value + 1);

            }

            sb
                .append(
                    clothes
                        .values()
                        .stream()
                        .reduce(1, (r, v) -> r *= v) - 1)
                .append('\n');

            clothes.clear();

        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static String readClothe() throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32)
            sb.append((char) c);
        return sb.toString();
    }

}
