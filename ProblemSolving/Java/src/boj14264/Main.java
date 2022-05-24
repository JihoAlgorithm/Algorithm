package boj14264;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(pow(read()) * 0.4330127019);
    }

    static long pow(long n) {
        return n * n;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}