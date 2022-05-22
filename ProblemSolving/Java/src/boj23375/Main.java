package boj23375;

class Main {

    public static void main(String[] args) throws Exception {

        int X = read();
        int Y = read();
        int R = read();

        StringBuilder sb = new StringBuilder();
        int[] dx = { 1, -1, -1, 1 };
        int[] dy = { 1, 1, -1, -1 };

        for (int i = 0; i < 4; i++) {
            sb
                .append(X + R * dx[i])
                .append(' ')
                .append(Y + R * dy[i])
                .append('\n');
        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
