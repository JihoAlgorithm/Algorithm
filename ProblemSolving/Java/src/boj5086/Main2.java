package boj5086;

class Main2 {

    static final int FACTOR = 0;
    static final int MULTIPLE = 1;
    static final int NEITHER = 2;
    static final char[][] ANSWER = {
        {'f', 'a', 'c', 't', 'o', 'r', '\n'},
        {'m', 'u', 'l', 't', 'i', 'p', 'l', 'e', '\n'},
        {'n', 'e', 'i', 't', 'h', 'e', 'r', '\n'}
    };

    public static void main(String[] args) throws Exception {

        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int a, b;

        while ((a = read()) != (b = read()))
            bw.write(ANSWER[check(a, b)]);

        bw.close();

    }

    static int check(int a, int b) {
        if (a < b) {
            for (int k = a; k < b;)
                if ((k += a) == b) return 0;
        } else {
            for (int k = b; k < a;)
                if ((k += b) == a) return 1;
        }
        return 2;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
