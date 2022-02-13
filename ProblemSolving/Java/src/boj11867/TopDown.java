package boj11867;

class TopDown {
    static char[][] cache;
    static final char INVALID = 'I', GAME_OVER = 'G', WIN = 'W'; 

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        if (N > M) {
            N = N + M;
            M = N - M;
            N = N - M;
        }

        cache = new char[M + 1][M + 1];

        System.out.println(play(N, M) == WIN ? 'A' : 'B');

    }

    static char play(int A, int B) {
        if (A == 0 || B == 0 || A > B) return INVALID;
        if (A == 1 && B == 1) return GAME_OVER;
        if (cache[A][B] != 0) return cache[A][B];

        cache[A][B] = INVALID;

        for (int i = 1; i <= (B >> 1); i++)
            if (check(play(i, B - i))) return cache[A][B] = WIN;
        for (int i = 1; i <= (A >> 1); i++)
            if (check(play(i, A - i))) return cache[A][B] = WIN;

        return cache[A][B];
    }

    static boolean check(char result) {
        return result == INVALID || result == GAME_OVER;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
