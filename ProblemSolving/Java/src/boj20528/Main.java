package boj20528;

class Main {

    public static void main(String[] args) throws Exception {
        int N = nextInt() - 1;
        byte S = nextPalindrome();

        while (N-- > 0) {
            if (S != nextPalindrome()) {
                S = 48;
                break;
            }
        }

        if (S > 48) S = 49;
        System.out.write(S);
        System.out.flush();
    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static byte nextPalindrome() throws Exception {
        while (read() > 32);
        return buf[idx - 2];
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
        if (idx == size) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
