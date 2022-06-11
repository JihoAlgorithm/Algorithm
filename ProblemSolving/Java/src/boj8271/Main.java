package boj8271;

class Main {

    static int n, rooks;
    static byte[][] board;
    static boolean[][] check;
    static final byte W = 'W';

    public static void main(String[] args) throws Exception {

        n = nextInt();
        board = new byte[n][n + 1];
        check = new boolean[2][n];

        for (int i = 0; i < n; i++) fillLine(i);

        while (rooks < n) {
            putRook();
            rooks++;
        }

        for (int i = 0; i < n; i++) {
            System.out.write(board[i]);
        }

    }

    static void putRook() {
        for (int r = 0; r < n; r++) {
            if (check[0][r]) continue;
            for (int c = 0; c < n; c++) {
                if (check[1][c]) continue;
                check[0][r] = check[1][c] = true;
                board[r][c] = W;
                return;
            }
        }
    }

    static int iidx, size, SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];

    static void fillLine(int row) throws Exception {
        int i = 0;
        byte c;
        while ((c = read()) <= 32);
        do {
            board[row][i++] = c;
            if (c == W) {
                rooks++;
                check[0][row] = check[1][i - 1] = true;
            }
        } while ((c = read()) > 32);
        board[row][n] = 10;
    }

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (iidx == size) {
            size = System.in.read(ibuf, iidx = 0, SIZE);
            if (size < 0) ibuf[0] = -1;
        }
        return ibuf[iidx++];
    }

}
