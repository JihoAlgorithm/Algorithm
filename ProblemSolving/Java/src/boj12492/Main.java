package boj12492;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Main {

    private static int T, R, C;
    private static char[][] tiles;
    private static BufferedWriter bw;

    private static final String IMPOSSIBLE = "Impossible";
    private static final int SHARP = 35;
    private static final int SLASH_NORMAL = 47;
    private static final int SLASH_REVERSE = 92;

    public static void main(String[] args) throws Exception {

        T = read();
        tiles = new char[50][50];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= T; t++) {
            init();
            printHeader(t);
            printTiles(tricky());
        }

        bw.close();

    }

    private static boolean tricky() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (tiles[r][c] == SHARP) {
                    if (isBound(r, c)) return false;
                    switchRed(r, c);
                }
            }
        }
        return true;
    }

    private static void switchRed(int r, int c) {
        tiles[r][c] = tiles[r + 1][c + 1] = SLASH_NORMAL;
        tiles[r + 1][c] = tiles[r][c + 1] = SLASH_REVERSE;
    }

    private static boolean isBound(int r, int c) {
        return r + 1 == R || c + 1 == C || tiles[r + 1][c] != SHARP || tiles[r][c + 1] != SHARP;
    }

    private static void printTiles(boolean isPossible) throws Exception {
        if (isPossible) printPossible();
        else printImpossible();
    }

    private static void printPossible() throws Exception {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                bw.write(tiles[r][c]);
            }
            bw.newLine();
        }
    }

    private static void printImpossible() throws Exception {
        bw.write(IMPOSSIBLE);
        bw.newLine();
    }

    private static final String HEAD = "Case #";
    private static final String TAIL = ":\n";

    private static void printHeader(int testCase) throws Exception {
        bw.write(HEAD);
        bw.write(Integer.toString(testCase));
        bw.write(TAIL);
    }

    private static void init() throws Exception {
        R = read();
        C = read();
        setTiles();
    }

    private static void setTiles() throws Exception {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tiles[r][c] = (char) System.in.read();
            }
            System.in.read();
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
