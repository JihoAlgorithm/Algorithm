package boj1780;

class Main {

    static int minusOne, zero, plusOne;
    static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {

        int N = read();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = read();
            }
        }
        cut(0, 0, N, N, matrix);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    private static void cut(int ar, int ac, int br, int bc, int[][] matrix) {
        int offset = matrix[ar][ac];
        for (int r = ar; r < br; r++) {
            for (int c = ac; c < bc; c++) {
                if (offset == matrix[r][c]) continue;
                int size = (br - ar) / 3;
                cut(ar, ac, br - (size << 1), bc - (size << 1), matrix);
                cut(ar, ac + size, br - (size << 1), bc - size, matrix);
                cut(ar, ac + (size << 1), br - (size << 1), bc, matrix);
                cut(ar + size, ac, br - size, bc - (size << 1), matrix);
                cut(ar + size, ac + size, br - size, bc - size, matrix);
                cut(ar + size, ac + (size << 1), br - size, bc, matrix);
                cut(ar + (size << 1), ac, br, bc - (size << 1), matrix);
                cut(ar + (size << 1), ac + size, br, bc - size, matrix);
                cut(ar + (size << 1), ac + (size << 1), br, bc, matrix);
                return;
            }
        }
        answer[offset + 1]++;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
