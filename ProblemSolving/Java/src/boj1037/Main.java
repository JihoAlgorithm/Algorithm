package boj1037;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        long a = read();
        int b = 0;
        int min = (int) a;
        int max = (int) a;

        while (--N > 0) {

            b = read();
            if (min > b) min = b;
            if (max < b) max = b;

            a = a * b / gcd(a, b);

        }

        System.out.print(a == max ? a * min : a);

    }

    static long gcd(long a, long b) {
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
