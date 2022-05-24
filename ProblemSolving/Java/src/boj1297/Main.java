package boj1297;

class Main {

    public static void main(String[] args) throws Exception {

        int squareD = pow(read());
        int squareH = pow(read());
        int squareW = pow(read());
        double diagonalRatio = (double) squareD / (squareH + squareW);

        System.out.println(
            new StringBuilder()
                .append((int) sqrt(diagonalRatio * squareH))
                .append(' ')
                .append((int) sqrt(diagonalRatio * squareW))
        );

    }

    static int pow(int n) {
        return n * n;
    }

    static double sqrt(double n) {
        int PRECISION = 30;
        double x = PRECISION;

        for (int i = 0; i < PRECISION; i++)
            x = 0.5 * (n / x + x);

        return x;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
