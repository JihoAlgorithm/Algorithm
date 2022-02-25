package boj1629;

/**
 * Time Limit Exceeded
 * O(N)으로는 어림도 없는 문제
 */
class Main {

    public static void main(String[] args) throws Exception {
        long A = read();
        int B = read();
        int C = read();

        A %= C;
        B %= C;

        while (B-- > 0) {
            A *= A;
            A %= C;
        }

        System.out.println(A);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
