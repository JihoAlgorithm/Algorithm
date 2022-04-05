package boj22973;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.print(jump(read()));
    }

    static int jump(long K) {

        if (K == 0) return 0;
        if ((K & 1) == 0) return -1;

        long hw = 1L;
        int time = 1;

        while ((hw <<= 1) < K)
            time++;

        return time;

    }

    static long read() throws Exception {
        int c;
        long n = System.in.read() & 15;
        if (n == 13) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
