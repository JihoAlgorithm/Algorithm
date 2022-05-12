package boj2263;

class Main {

    static int N;
    static int[] in, post;
    static int[] index = new int[100_001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        N = read();
        in = new int[N];
        post = new int[N];

        for (int i = 0; i < N; i++) index[in[i] = read()] = i;
        for (int i = 0; i < N; i++) post[i] = read();

        preorder(0, N - 1, 0, N - 1);

        System.out.print(sb);

    }

    static void preorder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;

        int root = index[post[pe]];
        int size = root - is;

        sb.append(in[root]).append(' ');

        preorder(is, root - 1, ps, ps + size - 1);
        preorder(root + 1, ie, ps + size, pe - 1);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
