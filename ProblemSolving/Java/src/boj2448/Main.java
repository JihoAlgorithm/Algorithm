package boj2448;

class Main {

    static byte[][] map;

    public static void main(String[] args) throws Exception {

        int N = read();

        int row = N;
        int col = N << 1;

        map = new byte[row][col + 1];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                map[r][c] = 32;
            }
            map[r][col] = '\n';
        }

        dfs(0, 0, N);

        for (int r = 0; r < row; r++) {
            System.out.write(map[r]);
        }

        System.out.close();

    }

    static void dfs(int r, int c, int size) {
        if (size == 3) {
            map[r][c + 2] = 42;
            map[r + 1][c + 1] = map[r + 1][c + 3] = 42;
            for (int i = 0; i < 5; i++) map[r + 2][c + i] = 42;
        } else {
            size >>= 1;
            dfs(r, c + size, size);
            dfs(r + size, c, size);
            dfs(r + size, c + (size << 1), size);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
