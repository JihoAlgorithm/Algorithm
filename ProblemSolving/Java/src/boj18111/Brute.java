package boj18111;

class Brute {

    static final int MAX = 256;

    public static void main(String[] args) throws Exception {

        int time = Integer.MAX_VALUE;
        int height = 0;

        int N = read();
        int M = read();
        int B = read();

        int[] heights = new int[MAX + 1];
        int mapSize = N * M;
        int blocks = 0;

        int minHeight = MAX;
        int maxHeight = 0;

        for (int i = 0; i < mapSize; i++) {
            int h = read();
            heights[h]++;
            blocks += h;
            if (minHeight > h) minHeight = h;
        }

        maxHeight = B + blocks < (mapSize << 8) ? (B + blocks) / mapSize : MAX;
        int t = (blocks - minHeight * mapSize) << 1;
        blocks = 0;

        time = t;
        height = minHeight;

        for (int h = minHeight + 1; h <= maxHeight; h++) {

            blocks += heights[h - 1];
            t += blocks - ((mapSize - blocks) << 1);

            if (time >= t) {
                time = t;
                height = h;
            }

        }

        System.out.print(
            new StringBuilder()
                .append(time).append(' ').append(height)
        );

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
