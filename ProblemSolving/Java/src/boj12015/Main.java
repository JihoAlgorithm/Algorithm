package boj12015;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] A = new int[N];
        int[] lis = new int[N];

        int k = 0;
        lis[k] = A[0] = read();

        for (int i = 1; i < N; i++) {

            A[i] = read();

            if (lis[k] < A[i])
                lis[++k] = A[i];
            else {
                int m, l, r;
                l = 0;
                r = k;
                while (l < r)
                    if (lis[m = l + r >> 1] < A[i]) l = m + 1;
                    else r = m;
                lis[r] = A[i];
            }

        }

        System.out.print(k + 1);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
