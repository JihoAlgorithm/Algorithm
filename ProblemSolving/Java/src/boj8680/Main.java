package boj8680;

class Main {

    public static void main(String[] args) throws Exception {
        int n = read() - 1;
        int h = read();
        int i = 0;

        while (h-- > 0) {
            i <<= 1;
            i |= n & 1;
            n >>= 1;
        }

        System.out.print(i);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
