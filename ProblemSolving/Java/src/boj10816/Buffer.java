package boj10816;

class Buffer {

    static int N;
    static int[] deck;

    static final int MIN = -10_000_001;
    static final int MAX = 10_000_001;

    public static void main(String[] args) throws Exception {

        N = read();
        fillCards();

        int M = read();
        Printer printer = new Printer();

        while (M-- > 0) {

            int card = read();
            int ceil = upperBound(deck, card);
            int floor = lowerBound(deck, card);

            if (deck[floor] != card) printer.write(0);
            else printer.write(ceil - floor);

        }

        printer.print();

    }

    static int upperBound(int[] deck, int card) {
        int m, l = 0, r = N + 2;

        while (l < r)
            if (deck[m = l + r >> 1] > card) r = m;
            else l = m + 1;

        return r;
    }

    static int lowerBound(int[] deck, int card) {
        int m, l = 0, r = N + 2;

        while (l < r)
            if (deck[m = l + r >> 1] < card) l = m + 1;
            else r = m;

        return r;
    }

    static void fillCards() throws Exception {
        deck = new int[N + 2];
        for (int i = 0; i < N; i++) deck[i] = read();
        deck[N] = MIN;
        deck[N + 1] = MAX;
        quickSort(deck, 0, N + 1);
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m, r);
    }

    static int partition(int[] arr, int l, int r) {
        int p = arr[l + r >> 1];
        while (l <= r) {
            while (arr[l] < p) l++;
            while (arr[r] > p) r--;
            if (l <= r) swap(arr, l++, r--);
        }
        return l;
    }

    static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}

class Printer {

    final int SIZE;

    char[] buffer;
    int pointer;
    java.io.BufferedWriter bw;

    Printer() {
        SIZE = 1024;
        buffer = new char[SIZE];
        bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    }

    void write(int num) {

        if (num == 0) {
            if (pointer + 2 >= SIZE) flush();
            buffer[pointer++] = 48;
            buffer[pointer++] = 32;
            return;
        }

        int len = (int) Math.log10(num) + 1;
        if (pointer + len + 1 >= SIZE) flush();

        int i = pointer += len;

        while (num > 0) {
            buffer[--i] = (char) (num % 10 | 48);
            num /= 10;
        }

        buffer[pointer++] = 32;

    }

    void flush() {
        try {
            bw.write(buffer, 0, pointer);
        } catch (Exception e) {}
        pointer = 0;
    }

    void print() {
        try {
            flush();
            bw.close();
        } catch (Exception e) {}
    }

}
