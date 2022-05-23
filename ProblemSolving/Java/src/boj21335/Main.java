package boj21335;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.printf("%.9f", 2 * Math.PI * Math.sqrt(read() / Math.PI));
    }

    static long read() throws Exception {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
