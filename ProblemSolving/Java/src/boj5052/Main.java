package boj5052;

class Main {

    static final int MAX_SIZE = 10_000;
    static final int LENGTH = 10;

    public static void main(String[] args) throws Exception {

        int t = nextInt();
        String[] numbers = new String[MAX_SIZE];

        while (t-- > 0) {

            int n = nextInt();

            for (int i = 0; i < n; i++) {
                numbers[i] = nextNumber();
            }

            java.util.Arrays.sort(numbers, 0, n);

            boolean isAvailable = true;

            for (int i = 1; i < n; i++) {
                if (numbers[i - 1].length() < numbers[i].length()) {
                    if (numbers[i].indexOf(numbers[i - 1]) == 0) {
                        isAvailable = false;
                        break;
                    }
                }
            }

            if (isAvailable) {
                writeYES();
            } else {
                writeNO();
            }

        }

        flush();

    }

    static int iidx, oidx, size;
    static final int SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];

    static void writeYES() {
        if (oidx + 3 >= SIZE) flush();
        obuf[oidx++] = 'Y';
        obuf[oidx++] = 'E';
        obuf[oidx++] = 'S';
        obuf[oidx++] = '\n';
    }

    static void writeNO() {
        if (oidx + 2 >= SIZE) flush();
        obuf[oidx++] = 'N';
        obuf[oidx++] = 'O';
        obuf[oidx++] = '\n';
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

    static byte[] temp = new byte[10];

    static String nextNumber() throws Exception {
        byte c, i = 0;
        while ((c = read()) <= 32);
        do temp[i++] = c;
        while (47 < (c = read()) && c < 58);
        return new String(temp, 0, i);
    }

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == iidx) {
            size = System.in.read(ibuf, iidx = 0, SIZE);
            if (size < 0) ibuf[0] = -1;
        }
        return ibuf[iidx++];
    }

}
