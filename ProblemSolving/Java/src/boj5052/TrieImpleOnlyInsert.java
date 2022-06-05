package boj5052;

public class TrieImpleOnlyInsert {

    static byte[] number = new byte[11];

    public static void main(String[] args) throws Exception {

        int t = nextInt();

        while (t-- > 0) {

            int n = nextInt();

            Trie trie = new Trie();
            boolean isAvailable = true;

            for (int i = 0; i < n; i++) {
                nextNumber();
                if (isAvailable) {
                    isAvailable = trie.insert(number);
                }
            }

            write(isAvailable);

        }

        flush();

    }

    static int iidx, oidx, size;
    static final int SIZE = 1 << 9;
    static byte[] buffer = new byte[SIZE];
    // static byte[] buffer = new byte[SIZE];

    static void write(boolean isAvailable) {
        if (oidx + 2 >= SIZE) flush();

        if (isAvailable) {
            buffer[oidx++] = 'Y';
            buffer[oidx++] = 'E';
            buffer[oidx++] = 'S';
        } else {
            buffer[oidx++] = 'N';
            buffer[oidx++] = 'O';
        }
        buffer[oidx++] = '\n';
    }

    static void flush() {
        System.out.write(buffer, 0, oidx);
        oidx = 0;
    }

    static void nextNumber() throws Exception {
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
            size = System.in.read(buffer, iidx = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[iidx++];
    }

    static class Trie {

        boolean isEnd;
        Trie[] children = new Trie[10];

        boolean insert(byte[] number) {
            Trie t = this;
            int length = number[10];

            for (int i = 0; i < length; i++) {
                int index = number[i] & 15;

                if (t.children[index] == null) {
                    t.children[index] = new Trie();
                } else {
                    if (t.children[index].isEnd && i + 1 != length) {
                        return false;
                    }
                    if (i + 1 == length) {
                        return false;
                    }
                }

                t = t.children[index];
            }

            return t.isEnd = true;
        }

    }

}
