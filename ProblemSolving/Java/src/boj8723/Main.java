package boj8723;

class Main {

    public static void main(String[] args) throws Exception {
        System.out.write(whatKindOfTriangle(read(), read(), read()));
        System.out.close();
    }

    static int whatKindOfTriangle(int a, int b, int c) {
        int t = 0;

        if (a > c) {
            t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        if (a == b && b == c && c == a) return 50;
        if (c * c == a * a + b * b) return 49;
        return 48;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
