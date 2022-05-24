package boj16600;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(sqrt(read()) * 4);
    }

    static final int PRECISION = 30;

    static double sqrt(double n) {
        double x = PRECISION;

        for (int i = 0; i < PRECISION; i++)
            x = 0.5 * (n / x + x);

        return x;
    }

    static long read() throws Exception {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
