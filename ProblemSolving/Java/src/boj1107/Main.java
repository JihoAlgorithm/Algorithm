package boj1107;

class Main {

    static boolean[] button;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        button = new boolean[10];
        for (int i = 0; i < M; i++) button[read()] = true;

        if (N == 100) {
            System.out.print(0);
            return;
        }

        final int MAX = (N << 1) < 100 ? 100 : (N << 1);

        int count = Math.abs(N - 100);

        if (!button[0] && count > 1 + N) count = 1 + N;

        for (int ch = 1; ch <= MAX; ch++) {
            int c = pressCount(ch);
            if (c > 0) {
                c += Math.abs(N - ch);
                if (count > c) count = c;
            }
        }

        System.out.print(count);

    }

    static int pressCount(int ch) {
        int cnt = 0;
        while (ch > 0) {
            if (button[ch % 10]) return -1;
            cnt++;
            ch /= 10;
        }
        return cnt;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
