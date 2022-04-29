package boj5639;

class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] tree = new int[10_000];

    public static void main(String[] args) throws Exception {

        int c, i = 0;

        while ((c = read()) > 0) tree[i++] = c;

        postOrder(0, i);
        System.out.print(sb);

    }

    static void postOrder(int s, int e) {
        if (s >= e) return;

        int p = upperBound(tree[s], s + 1, e);

        postOrder(s + 1, p);
        postOrder(p, e);
        sb.append(tree[s]).append('\n');

    }

    static int upperBound(int k, int s, int e) {
        int m = 0;
        while (s < e)
            if (tree[m = s + e >> 1] < k) s = m + 1;
            else e = m;
        return e;
    }
    
    static int read() throws Exception {
        int c = System.in.read();
        if (c < 0) return -1;
        int n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
