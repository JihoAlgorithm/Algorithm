package boj5086;

class Main {

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
            bw.write(ANSWER[a % b == 0 ? MULTIPLE : b % a == 0 ? FACTOR : NEITHER]);

        bw.close();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
