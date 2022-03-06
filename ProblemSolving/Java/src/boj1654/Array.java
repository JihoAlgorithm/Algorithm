package boj1654;

class Array {

    public static void main(String[] args) throws Exception {

        int K = read();
        int N = read();

        int[] lines = new int[K];
        for (int i = 0; i < K; i++) lines[i] = read();
        quickSort(lines, 0, K - 1);

        long l, m, r;
        l = 0;
        r = lines[K - 1];

        while (l < r)
            if (sum(lines, m = l + r + 1 >> 1) < N) r = m - 1;
            else l = m;

        System.out.print(r);

    }

    static int sum(int[] lines, long o) {
        int s = 0;
        for (int line : lines) s += line / o;
        return s;
    }

    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = partition(a, l, r);
        quickSort(a, l, m - 1);
        quickSort(a, m, r);
    }

    static int partition(int[] a, int l, int r) {
        int o = a[l + r >> 1];
        while (l <= r) {
            while (a[l] < o) l++;
            while (a[r] > o) r--;
            if (l <= r) swap(a, l++, r--);
        }
        return l;
    }

    static void swap(int[] a, int l, int r) {
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
