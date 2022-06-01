package boj20282;

class Main {

    public static void main(String[] args) throws Exception {

        int C = read();

        int[] points = new int[C + 1];
        int maxPoint = points[0] = 100;

        for (int i = 1; i <= C; i++) {
            points[i] = points[i - 1] + read();
            if (maxPoint < points[i]) {
                maxPoint = points[i];
            }
        }

        System.out.print(maxPoint);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
