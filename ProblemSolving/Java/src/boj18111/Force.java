package boj18111;

class Force {

    static final int MAX = 256;

    public static void main(String[] args) throws Exception {

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;

        int N = read();
        int M = read();
        int B = read();

        int[] heights = new int[MAX + 1];
        int mapSize = N * M;

        int minHeight = MAX;
        int maxHeight = 0;

        for (int i = 0; i < mapSize; i++) {
            int h = read();
            heights[h]++;
            if (minHeight > h) minHeight = h;
            if (maxHeight < h) maxHeight = h;
        }

        for (int t = minHeight; t <= maxHeight; t++) {

            int time = 0;
            int inventory = B;

            for (int h = minHeight; h <= maxHeight; h++) {

                if (heights[h] == 0 || t == h) continue;

                int block = Math.abs(t - h) * heights[h];

                if (t < h) {
                    time += block << 1;
                    inventory += block;
                } else {
                    time += block;
                    inventory -= block;
                }

            }

            if (inventory < 0) continue;

            if (answerTime >= time) {
                answerTime = time;
                answerHeight = t;
            }

        }

        System.out.print(
            new StringBuilder()
                .append(answerTime).append(' ').append(answerHeight)
        );

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
