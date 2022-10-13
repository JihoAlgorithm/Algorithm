package boj12833;

class Main {
    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        int C = read();
        System.out.print((C & 1) == 0 ? A : A ^ B);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}
