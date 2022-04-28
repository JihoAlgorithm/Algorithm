package boj16953;

class TopDown {

    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        int count = 1;

        while (A < B) {
            if (B % 2 == 0) B >>= 1;
            else if (B % 10 == 1) B /= 10;
            else break;
            count++;
        }

        System.out.print(A == B ? count : -1);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
