package boj5052;

class TrieImplement {

    static byte[][] numbers = new byte[10_000][11];

    public static void main(String[] args) throws Exception {

        int t = nextInt();

        while (t-- > 0) {

            int n = nextInt();
            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                nextNumber(numbers[i]);
                trie.insert(numbers[i]);
            }

            boolean isAvailable = true;

            for (int i = 0; i < n; i++) {
                if (trie.find(numbers[i])) {
                    isAvailable = false;
                    break;
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

    static void nextNumber(byte[] number) throws Exception {
        byte c, i = 0;
        while ((c = read()) <= 32);
        do number[i++] = c;
        while (47 < (c = read()) && c < 58);
        number[10] = i;
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

    static class Trie {

        boolean isEnd;
        Trie[] children = new Trie[10];

        void insert(byte[] number) {
            Trie t = this;
            int length = number[10];

            for (int i = 0; i < length; i++) {
                int index = number[i] & 15;
                if (t.children[index] == null) {
                    t.children[index] = new Trie();
                }
                t = t.children[index];
            }

            t.isEnd = true;
        }

        boolean find(byte[] number) {
            Trie t = this;
            int length = number[10];

            for (int i = 0; i < length; i++) {
                if (t.isEnd) return true;
                t = t.children[number[i] & 15];
            }

            return false;
        }

    }

}
