package boj1644;

class Main {

    static int N;
    static boolean[] prime;

    public static void main(String[] args) throws Exception {

        N = read();
        prime = new boolean[N + 1];

        sift();

        int pointerL = 0;
        int pointerR = 0;
        int prefixSum = 0;
        int count = 0;

        while (pointerR <= N) {

            prefixSum += pointerR = nextPrime(pointerR);

            while (prefixSum > N) {
                prefixSum -= pointerL;
                pointerL = nextPrime(pointerL);
            }

            if (prefixSum == N) count++;

        }

        System.out.println(count);

    }

    static int nextPrime(int pointer) {
        while (++pointer <= N) if (!prime[pointer]) break;
        return pointer;
    }

    static void sift() {
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) continue;
            for (int j = 2; i * j <= N; j++) {
                prime[i * j] = true;
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
