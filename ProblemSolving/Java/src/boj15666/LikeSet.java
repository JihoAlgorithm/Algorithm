package boj15666;

class LikeSet {

    static int N, M;
    static int[] num, seq;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        seq = new int[M];

        int min = 10_000;
        int max = 1;
        int duplicatedNum = 0;

        boolean[] set = new boolean[10_001];
        for (int i = 0; i < N; i++) {
            int n = read();

            if (set[n]) duplicatedNum++;
            set[n] = true;

            if (min > n) min = n;
            if (max < n) max = n;
        }

        int size = 0;
        num = new int[N -= duplicatedNum];
        for (int i = min; i <= max; i++)
            if (set[i]) num[size++] = i;

        dfs(0, 0);

        flush();
        bw.close();

    }

    static void dfs(int cnt, int idx) throws Exception {
        if (cnt == M) {
            write();
            return;
        }
        for (int i = idx; i < N; i++) {
            seq[cnt] = num[i];
            dfs(cnt + 1, i);
        }
    }

    static final int BUFFER_SIZE = 1 << 13;
    static java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static char[] buffer = new char[BUFFER_SIZE];
    static int bufferIndex;

    static void write() throws Exception {
        if (bufferIndex + 6 * M >= BUFFER_SIZE) flush();

        for (int i = 0; i + 1 < M; i++) {
            write(seq[i]);
            buffer[bufferIndex++] = 32;
        }
        write(seq[M - 1]);
        buffer[bufferIndex++] = 10;
    }

    static void write(int n) {
        int i = (int) Math.log10(n) + 1;
        bufferIndex += i;
        i = bufferIndex;

        do buffer[--i] = (char) (n % 10 | 48);
        while ((n /= 10) > 0);
    }

    static void flush() throws Exception {
        bw.write(buffer, 0, bufferIndex);
        bufferIndex = 0;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
