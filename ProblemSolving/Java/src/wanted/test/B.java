package wanted.test;

class B {

    static int minRemainBall = 50;
    static int[][] board;

    public static void main(String[] args) throws Exception {

        board = new int[8][7];
        int[][] originBorad = new int[8][7];

        for (int r = 1; r < 8; r++) {
            for (int c = 0; c < 7; c++) {
                originBorad[r][c] = board[r][c] = nextInt();
            }
        }

        int number = nextInt();

        for (int c = 0; c < 7; c++) {
            dropBall(c, number);
            rollback(originBorad);
        }

        System.out.print(minRemainBall);

    }

    static void dropBall(int c, int number) {
        for (int r = 7; r > 2; r--) {
            if (board[r][c] == 0) {
                board[r][c] = number;
                break;
            }
        }

        while (bombBalls() > 0);

        int remainBalls = countRemainBalls();

        if (minRemainBall > remainBalls) minRemainBall = remainBalls;
    }

    static int[][] stack = new int[50][2];
    static int top;

    static int bombBalls() {
        int balls = 0;
        top = -1;

        for (int r = 1; r < 8; r++) {
            for (int c = 0; c < 7; c++) {
                if (board[r][c] > 0) {
                    int s = c;
                    while(c < 7 && board[r][c] > 0) c++;
                    int size = c - s;
                    for (int i = s; i < c; i++) {
                        if (board[r][i] == size) {
                            top++;
                            stack[top][0] = r;
                            stack[top][1] = i;
                        }
                    }
                }
            }
        }

        for (int c = 0; c < 7; c++) {
            for (int r = 1; r < 8; r++) {
                if (board[r][c] > 0) {
                    int s = r;
                    while(r < 8 && board[r][c] > 0) r++;
                    int size = r - s;
                    for (int i = s; i < r; i++) {
                        if (board[i][c] == size) {
                            top++;
                            stack[top][0] = i;
                            stack[top][1] = c;
                        }
                    }
                }
            }
        }

        while (top >= 0) {
            int r = stack[top][0];
            int c = stack[top][1];
            if (board[r][c] > 0) {
                balls++;
                board[r][c] = 0;
            }
            top--;
        }

        for (int c = 0; c < 7; c++) {
            int r = 8;
            while (r > 0) {
                if (board[--r][c] > 0) {
                    stack[++top][0] = board[r][c];
                    board[r][c] = 0;
                }
            }
            r = 8;
            for (int t = 0; t <= top; t++) {
                board[--r][c] = stack[t][0];
            }
            top = -1;
        }

        return balls;
    }

    static void rollback(int[][] originBoard) {
        for (int r = 1; r < 8; r++) {
            for (int c = 0; c < 7; c++) {
                board[r][c] = originBoard[r][c];
            }
        }
    }

    static int countRemainBalls() {
        int cnt = 0;
        for (int r = 1; r < 8; r++) {
            for (int c = 0; c < 7; c++) {
                if (board[r][c] > 0) cnt++;
            }
        }
        return cnt;
    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
