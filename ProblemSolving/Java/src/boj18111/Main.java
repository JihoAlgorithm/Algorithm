package boj18111;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int B = read();

        int mapSize = N * M;
        int[] map = new int[mapSize];

        int time = Integer.MAX_VALUE;
        int height = 0;

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < mapSize; i++) {
            int block = read();
            map[i] = block;

            if (minHeight > block) minHeight = block;
            if (maxHeight < block) maxHeight = block;
        }

        int targetHeight = minHeight;

        while (targetHeight <= maxHeight) {

            int t = 0;
            int inventory = B;

            for (int i = 0; i < mapSize; i++) {
                int diff = map[i] - targetHeight;
                if (diff > 0) inventory += diff;
            }

            for (int i = 0; i < mapSize; i++) {
                int h = map[i];
                if (h == targetHeight) continue;
                if (h < targetHeight) {
                    int diff = targetHeight - h;
                    if (inventory < diff) {
                        t = Integer.MAX_VALUE;
                        break;
                    }
                    inventory -= diff;
                    t += diff;
                } else {
                    int diff = h - targetHeight;
                    t += diff << 1;
                    // inventory += diff;
                }
            }

            if (time >= t) {
                time = t;
                height = targetHeight;
            }

            targetHeight++;

        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append(' ').append(height);
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
