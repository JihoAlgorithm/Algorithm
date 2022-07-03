package watering;

class Watering4 {

    static int R, C;

    static final byte[][][][] tissue = {
        {
            {
                { '#', 'a', 'b', 'b', 'b' },
                { 'a', 'a', 'c', 'c', 'c' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', '#', 'b', 'b', 'b' },
                { 'a', 'a', 'c', 'c', 'c' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'a', '#', 'b', 'b' },
                { 'a', 'c', 'c', 'c', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'a', 'c', '#', 'b' },
                { 'a', 'c', 'c', 'b', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'a', 'c', 'b', '#' },
                { 'a', 'c', 'c', 'b', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            }
        },
        {
            {
                { 'a', 'a', 'c', 'c', 'c' },
                { '#', 'a', 'b', 'b', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'a', 'c', 'c', 'c' },
                { 'a', '#', 'b', 'b', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'c', 'c', 'c', 'b' },
                { 'a', 'a', '#', 'b', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'c', 'c', 'b', 'b' },
                { 'a', 'a', 'c', '#', 'b' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            },
            {
                { 'a', 'c', 'c', 'b', 'b' },
                { 'a', 'a', 'c', 'b', '#' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
            }
        },
        {
            {
                { 'a', 'a', 'c', 'c', 'c' },
                { 'a', 'e', 'b', 'b', 'b' },
                { '#', 'e', 'e', 'g', 'h' },
                { 'd', 'f', 'f', 'g', 'h' },
                { 'd', 'd', 'f', 'g', 'h' },
            },
            {
                { 'h', 'h', 'a', 'a', 'a' },
                { 'g', 'h', 'b', 'b', 'b' },
                { 'g', '#', 'c', 'c', 'c' },
                { 'g', 'f', 'd', 'd', 'd' },
                { 'f', 'f', 'e', 'e', 'e' },
            },
            {
                { 'a', 'a', 'a', 'h', 'e' },
                { 'b', 'b', 'b', 'h', 'e' },
                { 'g', 'f', '#', 'h', 'e' },
                { 'g', 'f', 'c', 'c', 'c' },
                { 'g', 'f', 'd', 'd', 'd' },
            },
            {
                { 'a', 'c', 'c', 'b', 'b' },
                { 'a', 'a', 'c', 'b', 'h' },
                { 'd', 'e', 'f', '#', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'g' },
            },
            {
                { 'a', 'c', 'c', 'b', 'b' },
                { 'a', 'a', 'c', 'g', 'b' },
                { 'd', 'e', 'f', 'g', '#' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'h', 'h' },
            }
        },
        {
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { '#', 'a', 'b', 'b', 'b' },
                { 'a', 'a', 'c', 'c', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', '#', 'b', 'b', 'b' },
                { 'a', 'a', 'c', 'c', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'a', '#', 'c', 'c' },
                { 'a', 'b', 'b', 'b', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'a', 'b', '#', 'c' },
                { 'a', 'b', 'b', 'c', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'a', 'b', 'c', '#' },
                { 'a', 'b', 'b', 'c', 'c' },
            },
        },
        {
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'a', 'c', 'c', 'c' },
                { '#', 'a', 'b', 'b', 'b' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'a', 'c', 'c', 'c' },
                { 'a', '#', 'b', 'b', 'b' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'b', 'b', 'b', 'c' },
                { 'a', 'a', '#', 'c', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'b', 'b', 'c', 'c' },
                { 'a', 'a', 'b', '#', 'c' },
            },
            {
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'd', 'e', 'f', 'g', 'h' },
                { 'a', 'b', 'b', 'c', 'c' },
                { 'a', 'a', 'b', 'c', '#' },
            },
        },
    };

    public static void main(String[] args) throws Exception {

        R = nextInt();
        C = nextInt();

        int sizeR = (R << 2) + (R << 1);
        int sizeC = (C << 2) + (C << 1);

        byte[][] farm = new byte[sizeR][sizeC];

        for (int r = 0; r < sizeR - 1; r++) {
            for (int c = 0; c < sizeC; c++) {
                farm[r][c] = read();
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int x = 0, y = 0;
                findScarecrow: for (int i = 6 * r; i < 6 * r + 5; i++) {
                    for (int j = 6 * c; j < 6 * c + 5; j++) {
                        if (farm[i][j] == '#') {
                            x = i - 6 * r;
                            y = j - 6 * c;
                            break findScarecrow;
                        }
                    }
                }
                byte[][] cell = tissue[x][y];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        farm[6 * r + i][6 * c + j] = cell[i][j];
                    }
                }
            }
        }

        for (int r = 0; r < sizeR - 1; r++) {
            System.out.write(farm[r]);
        }

    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
