package boj1174;

import java.util.Arrays;

class Recursive {

    static final int MAX_COUNT = 1 << 10;
    static int N, index;
    static long[] numbers;

    public static void main(String[] args) throws Exception {
        N = read();
        System.out.println(findDecreasingNumber());
    }

    static long findDecreasingNumber() {
        if (N <= 11) return N - 1;
        if (N >= MAX_COUNT) return -1;
        return dfs();
    }

    static long dfs() {
        numbers = new long[MAX_COUNT];
        for (int i = 0; i < 10; i++) dfs(i, 1);
        Arrays.sort(numbers);
        return numbers[N];
    }

    static void dfs(long number, int count) {
        if (count > 10) return;
        numbers[index++] = number;
        for (int i = 0; i < number % 10; i++)
            dfs((number << 3) + (number << 1) + i, count + 1);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
