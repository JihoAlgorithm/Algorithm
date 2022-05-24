package boj20352;

class Main {

    public static void main(String[] args) throws Exception {

        double area = read();
        double radius = sqrt(area / Math.PI);
        double length = 2 * Math.PI * radius;

        System.out.print(length);

    }

    static final int PRECISION = 10;

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
