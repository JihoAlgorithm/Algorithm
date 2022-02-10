package boj1174;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Main {

    static final int MAX_COUNT = (1 << 10) - 1;

    static int N;
    static ArrayList<Long> numbers = new ArrayList<>(MAX_COUNT);

    public static void main(String[] args) throws Exception {

        N = read();
        long answer;

        if (N < 11)
            answer = N - 1;
        else if (N > MAX_COUNT)
            answer = -1;
        else
            answer = findDecreasingNumber();

        System.out.println(answer);

    }

    static long findDecreasingNumber() {
        for (int i = 1; i <= MAX_COUNT; i++) {
            long decresedNumber = 0;
            for (int j = 0; j < 10; j++)
                if ((i & (1 << j)) != 0)
                    decresedNumber = (decresedNumber << 3) + (decresedNumber << 1) + (9 - j);
            numbers.add(decresedNumber);
        }

        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                    .get(N - 1);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
