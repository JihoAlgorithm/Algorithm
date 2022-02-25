package boj1629;

class ExponentialLaw {

    static int C;

    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        C = read();

        System.out.println(pow(A, B));
    }

    static long pow(int A, int B) {
        if (B == 0) return 1;
        long X = pow(A, B >> 1);
        X *= X;
        X %= C;
        if ((B & 1) != 0) {
            X *= A;
            X %= C;
        }
        return X;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
