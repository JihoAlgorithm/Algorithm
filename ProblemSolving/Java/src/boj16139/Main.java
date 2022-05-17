package boj16139;

class Main {

    static final int SIZE = 200_000;
    static byte[] S = new byte[SIZE];
    static int stringLength = 0;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        readString();
        int[][] prefixSum = new int[27][stringLength + 1];

        for (int i = 1; i <= stringLength; i++) {
            for (int alphabet = 1; alphabet < 27; alphabet++) {
                prefixSum[alphabet][i] = prefixSum[alphabet][i - 1];
            }
            prefixSum[S[i - 1] & 31][i]++;
        }

        int Q = nextInt();

        while (Q-- > 0) {
            int alphabet = nextAlphabet();
            int start = nextInt();
            int end = nextInt() + 1;

            sb
                .append(prefixSum[alphabet][end] - prefixSum[alphabet][start])
                .append('\n');
        }

        System.out.println(sb);

    }

    static byte[] buffer = new byte[SIZE];
    static int index, size;
    static byte c;

    static void readString() throws Exception {
        while ((c = read()) > 32) S[stringLength++] = c;
    }

    static int nextAlphabet() throws Exception {
        while ((c = read()) <= 32);
        return c & 31;
    }

    static int nextInt() throws Exception {
        int n = 0;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 47 && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

}
