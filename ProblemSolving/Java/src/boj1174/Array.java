package boj1174;

import java.util.Arrays;

class Array {

    static final int MAX_COUNT = 1 << 10;
    static int N;

    public static void main(String[] args) throws Exception {
        N = read();
        System.out.println(findDecreasingNumber());
    }

    static long findDecreasingNumber() {
        if (N <= 11) return N - 1;
        if (N >= MAX_COUNT) return -1;
        return find();
    }

    static long find() {
        long[] numbers = new long[MAX_COUNT];

        for (int i = 1; i < MAX_COUNT; i++) {
            int count = i;
            for (int j = 9; j >= 0; j--) {
                if ((count & 1) > 0)
                    numbers[i] = (numbers[i] << 3) + (numbers[i] << 1) + j;
                count >>= 1;
            }
        }

        Arrays.sort(numbers);

        return numbers[N];
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
