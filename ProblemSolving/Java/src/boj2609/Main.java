package boj2609;

class Main {

    public static void main(String[] args) throws Exception {

        int a = read();
        int b = read();

        int gcd = gcd(a, b);
        int lcm = a * b / gcd;

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append('\n').append(lcm);
        System.out.print(sb);

    }

    static int gcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
