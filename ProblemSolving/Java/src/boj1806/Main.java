package boj1806;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int S = read();
        int[] sequence = new int[N];

        int prefixSum = 0;
        int pointerL = 0;
        int pointerR = -1;
        int length = 100_001;

        while (++pointerR < N) {

            prefixSum += sequence[pointerR] = read();

            while (prefixSum >= S) {
                length = Math.min(length, pointerR - pointerL + 1);
                prefixSum -= sequence[pointerL++];
            }

        }

        print(length > N ? 0 : length);

    }

    static void print(int num) {

        char[] buffer;

        if (num > 0) {
            int len = (int) Math.log10(num) + 1;
            buffer = new char[len];
            while (num > 0) {
                buffer[--len] = (char) (num % 10 | 48);
                num /= 10;
            }
        } else {
            buffer = new char[1];
            buffer[0] = 48;

        }

        java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(System.out);
        java.io.BufferedWriter bw = new java.io.BufferedWriter(osw);

        try {
            bw.write(buffer);
            bw.close();
        } catch (Exception e) {}

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
