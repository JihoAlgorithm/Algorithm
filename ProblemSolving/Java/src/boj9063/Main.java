package boj9063;

class Main {

    public static void main(String[] args) throws Exception {

        int balls = read();

        int minX, minY, maxX, maxY;
        minX = minY = 10000;
        maxX = maxY = -10000;

        while (balls-- > 0) {
            int x = read();
            int y = read();
            if (minX > x) minX = x;
            if (minY > y) minY = y;
            if (maxX < x) maxX = x;
            if (maxY < y) maxY = y;
        }

        System.out.print((maxX - minX) * (maxY - minY));

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
