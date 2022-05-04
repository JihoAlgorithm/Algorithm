package boj2480;

class Main {

    public static void main(String[] args) throws Exception {

        int a = read();
        int b = read();
        int c = read();

        int x = 0;

        if (a == b) {
            if (a == c) {
                x = 10000 + a * 1000;
            } else {
                x = 1000 + a * 100;
            }
        } else if (a == c) {
            if (a == b) {
                x = 10000 + a * 1000;
            } else {
                x = 1000 + a * 100;
            }
        } else if (b == c) {
            if (b == a) {
                x = 10000 + b * 1000;
            } else {
                x = 1000 + b * 100;
            }
        } else {
            x = Math.max(a, Math.max(b, c)) * 100;
        }

        System.out.println(x);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
