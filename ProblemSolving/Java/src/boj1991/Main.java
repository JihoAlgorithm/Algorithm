package boj1991;

class Main {

    static char[][] tree;
    static char[] buffer;
    static int a, b, c;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();
        tree = new char[N + 65][];

        for (int i = 0; i < N; i++) {
            char root = in.nextNode();
            tree[root] = new char[2];
            tree[root][0] = in.nextNode();
            tree[root][1] = in.nextNode();
        }

        int size = N + 1;
        buffer = new char[size * 3];
        a = size * 0;
        b = size * 1;
        c = size * 2;

        travel('A');
        buffer[a] = buffer[b] = buffer[c] = 10;

        System.out.print(buffer);

    }

    static void travel(char n) {
        if (n > 64) {
            buffer[a++] = n;
            travel(tree[n][0]);
            buffer[b++] = n;
            travel(tree[n][1]);
            buffer[c++] = n;
        }
    }

}

class Reader {
    final int MAX_SIZE = 1 << 13;
    byte[] buffer = new byte[MAX_SIZE];
    int index, size;

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return n;
    }

    char nextNode() throws Exception {
        byte node;
        while ((node = read()) <= 32);
        return (char) node;
    }

    private boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    private byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, MAX_SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}
