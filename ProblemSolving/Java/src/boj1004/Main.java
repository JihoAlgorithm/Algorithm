package boj1004;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();

        while (T-- > 0) {
            int X1 = read();
            int Y1 = read();
            int X2 = read();
            int Y2 = read();

            int star = read();
            int exit = 0;
            int land = 0;

            while (star-- > 0) {
                int x = read();
                int y = read();
                int r = read();
                r *= r;

                if (pow(x - X1) + pow(y - Y1) < r && pow(x - X2) + pow(y - Y2) > r) {
                    exit++;
                }
                if (pow(x - X1) + pow(y - Y1) > r && pow(x - X2) + pow(y - Y2) < r) {
                    land++;
                }
            }

            sb.append(exit + land).append('\n');
        }

        System.out.print(sb);

    }

    static int pow(int n) {
        return n * n;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
