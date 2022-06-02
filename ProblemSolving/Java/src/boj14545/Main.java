package boj14545;

class Main {

    public static void main(String[] args) throws Exception {

        int P = read();
        StringBuilder sb = new StringBuilder();

        while (P-- > 0) {

            int l = read();
            int squares = 0;

            for (int i = 1; i <= l; i++) {
                squares += i * i;
            }

            sb.append(squares).append('\n');

        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
