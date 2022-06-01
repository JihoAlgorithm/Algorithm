package boj6768;

class Main {

    public static void main(String[] args) throws Exception {
        int J = read();
        System.out.print(J < 4 ? 0 : combination(J - 1, 3));
    }

    static long combination(int n, int r) {
        if (r == 0 || n == r) return 1;
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
