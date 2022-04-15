package boj5525;

class Main {

    static final byte I = 73;
    static final byte O = 79;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        byte[] S = new byte[M + 1];
        System.in.read(S, 0, M);

        int i = 0;
        int length = 0;
        int result = 0;

        while (S[i++] != I);

        for (; i < M; i++) {
            if (isIO(S, i)) {
                length++;
            } else if (isOI(S, i)) {
                if (length >= N) result++;
            } else {
                length = 0;
            }
        }

        System.out.print(result);

    }

    static boolean isIO(byte[] S, int i) {
        return S[i - 1] == I && S[i] == O;
    }

    static boolean isOI(byte[] S, int i) {
        return S[i - 1] == O && S[i] == I;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
