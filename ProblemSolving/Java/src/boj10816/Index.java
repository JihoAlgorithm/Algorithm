package boj10816;

class Index {

    static final int OFFSET = 10_000_000;

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] indexCount = new int[(OFFSET << 1) + 1];
        Printer printer = new Printer();

        while (N-- > 0) indexCount[read() + OFFSET]++;

        int M = read();

        while (M-- > 0) printer.write(indexCount[read() + OFFSET]);

        printer.print();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
