package boj16400;

import java.util.ArrayList;

public class LessMemory {

    private static final int MOD = 123_456_789;
    private static int N;
    private static ArrayList<Integer> coins;
    private static int[] cache;

    public static void main(String[] args) throws Exception {

        N = read();
        coins = new ArrayList<>();
        cache = new int[N + 1];
        cache[0] = 1;

        setPrimeCoins();

        for (int coin : coins)
            for (int i = coin; i <= N; i++)
                cache[i] = (cache[i] + cache[i - coin]) % MOD;

        System.out.println(cache[N]);

    }

    private static void setPrimeCoins() {
        for (int n = 2; n <= N; n ++)
            if (isPrime(n)) coins.add(n);
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i+= 2)
            if (n % i == 0) return false;
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
