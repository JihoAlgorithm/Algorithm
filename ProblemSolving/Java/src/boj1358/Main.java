package boj1358;

class Main {

    static int X, Y, XW, YH, LX, LY, RX, RY, R_SQUARE;

    public static void main(String[] args) throws Exception {

        int W = read();
        int H = read();
        X = read();
        Y = read();
        XW = X + W;
        YH = Y + H;
        int radius = H >> 1;
        R_SQUARE = radius * radius;
        LX = X;
        LY = Y + radius;
        RX = XW;
        RY = Y + radius;

        int P = read();

        int player = 0;
        while (P-- > 0) {
            int x = read();
            int y = read();

            if (isInBox(x, y) || isInLeftCircle(x, y) || isInRightCircle(x, y)) {
                player++;
            }
        }

        System.out.print(player);

    }

    static boolean isInBox(int x, int y) {
        return x >= X && y >= Y && x <= XW && y <= YH;
    }

    static boolean isInLeftCircle(int x, int y) {
        return Math.pow(LX - x, 2) + Math.pow(LY - y, 2) <= R_SQUARE;
    }

    static boolean isInRightCircle(int x, int y) {
        return Math.pow(RX - x, 2) + Math.pow(RY - y, 2) <= R_SQUARE;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
