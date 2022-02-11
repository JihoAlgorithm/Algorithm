package boj21736;

import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int N, M, doyeonN, doyeonM;
    static char[][] campus;
    static final char BLANK = 'O', WALL = 'X', PERSON = 'P', VISITED = 'V';
    static int[] dn = {-1, 1, 0, 0};
    static int[] dm = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        int friends = findFriends();
        System.out.println(friends > 0 ? friends : "TT");
    }

    static int findFriends() {
        int friends = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{doyeonN, doyeonM});

        while (!queue.isEmpty()) {
            int[] doyeon = queue.poll();

            for (int d = 0; d < 4; d++) {
                doyeonN = doyeon[0] + dn[d];
                doyeonM = doyeon[1] + dm[d];
                if (isBound(doyeonN, doyeonM)) continue;
                if (campus[doyeonN][doyeonM] == PERSON) friends++;
                campus[doyeonN][doyeonM] = VISITED;
                queue.offer(new int[]{doyeonN, doyeonM});
            }
        }

        return friends;
    }

    static boolean isBound(int n, int m) {
        return n < 0 || n == N || m < 0 || m == M || campus[n][m] == WALL || campus[n][m] == VISITED;
    }

    static void init() throws Exception {
        N = read();
        M = read();
        campus = new char[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                campus[n][m] = (char) System.in.read();
                if (campus[n][m] == 'I') {
                    doyeonN = n;
                    doyeonM = m;
                }
            }
            System.in.read();
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
