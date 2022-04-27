package utils.io;

public class Reader {

    private final int SIZE = 1 << 13;

    private byte[] buffer = new byte[SIZE];
    private int index;
    private int size;

    private int n;
    private byte c;

    private final int STRING_SIZE = 64;
    private byte[] string = new byte[STRING_SIZE];

    public String next() throws Exception {
        n = 0;
        while ((c = read()) <= 32);
        do string[n++] = c;
        while ((c = read()) > 32);
        return new String(string, 0, n);
    }

    public int nextInt() throws Exception {
        n = 0;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return n;
    }

    public int nextSignedInt() throws Exception {
        n = 0;
        while ((c = read()) <= 32);
        boolean isNegative = c == 45;
        if (isNegative) c = read();
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isNegative ? ~n + 1 : n;
    }

    private boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    private byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

}
