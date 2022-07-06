package boj13155;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(pow(read()));
    }

    static long pow(int e) {
        long n = 8;
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r *= n;
            e >>= 1;
            n *= n;
        }
        return r;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
