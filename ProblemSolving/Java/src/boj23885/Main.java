package boj23885;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int sx = read();
        int ex = read();
        int sy = read();
        int ey = read();

        if (sx == sy && ex == ey) {
            System.out.print("YES");
        } else if (N == 1 || M == 1) {
            System.out.print("NO");
        } else {
            System.out.print((sx + sy & 1) == (ex + ey & 1) ? "YES" : "NO");
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
