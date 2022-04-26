package boj11660;

class Main {

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] table = new int[N + 1][N + 1];

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                table[x][y] = table[x][y - 1] + in.nextInt();
            }
        }

        while (M-- > 0) {

            int x1 = in.nextInt();
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            int prefixSum = 0;
            for (int x = x1; x <= x2; x++) {
                prefixSum += table[x][y2] - table[x][y1];
            }

            sb.append(prefixSum).append('\n');

        }

        System.out.print(sb);

    }

}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;
    int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return n;
    }
    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }
    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}
