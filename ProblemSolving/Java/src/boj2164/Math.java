package boj2164;

class Math {

    static java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        print(card(read()));
    }

    static int card(int N) {
        if (N == 1) return 1;
        int x = 1;
        while ((x <<= 1) < N);
        return N - (x >> 1) << 1;
    }

    static void print(int card) throws Exception {
        char[] buf = new char[6];
        int i = 6;
        while (card > 0) {
            buf[--i] = (char) (card % 10 | 48);
            card /= 10;
        }
        bw.write(buf, i, 6 - i);
        bw.close();
    }

    static int read() throws Exception {
        int c, n = br.read() & 15;
        while ((c = br.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
