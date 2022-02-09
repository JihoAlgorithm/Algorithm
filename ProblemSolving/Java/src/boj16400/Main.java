package boj16400;

public class Main {

    private static final int MOD = 123_456_789;
    private static int N;
    private static BinaryVisited numbers;
    private static int[] cache;

    public static void main(String[] args) throws Exception {

        N = read();
        numbers = new BinaryVisited(N);
        cache = new int[N + 1];
        cache[0] = 1;

        siftOut();

        for (int i = 2; i <= N; i++)
            if (numbers.isPrime(i))
                for (int j = i; j <= N; j++)
                    cache[j] = (cache[j] + cache[j - i]) % MOD;

        System.out.println(cache[N]);

    }

    private static void siftOut() {
        for (int i = 2; i * i <= N; i++)
            for (int j = i * i; j <= N; j += i)
                numbers.visit(j);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

class BinaryVisited {

    private static final int BIT = 5;
    private static final int MASK = (2 << BIT) - 1;

    private int[] visited;

    BinaryVisited(int size) {
        visited = new int[(size >> BIT) + 1];
    }

    void visit(int node) {
        visited[node >> BIT] |= 1 << (node & MASK);
    }

    boolean isPrime(int node) {
        return ((visited[node >> BIT] >> (node & MASK)) & 1) == 0;
    }

}
