package boj8271;

class Better {

    static final byte W = 'W';

    public static void main(String[] args) throws Exception {

        int r, c, i, n = 0;

        while ((i = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (i & 15);
        }

        byte[][] board = new byte[n][n + 1];
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];

        for (r = 0; r < n; r++) {
            System.in.read(board[r]);
            for (c = 0; c < n; c++) {
                if (board[r][c] == W) {
                    row[r] = col[c] = true;
                }
            }
        }

        r = c = 0;

        while (r < n && c < n) {
            if (row[r]) r++;
            else if (col[c]) c++;
            else {
                board[r][c] = W;
                r++;
                c++;
            }
        }

        for (i = 0; i < n; i++) {
            System.out.write(board[i]);
        }

    }

}
