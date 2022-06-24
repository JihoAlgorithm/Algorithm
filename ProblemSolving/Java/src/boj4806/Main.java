package boj4806;

class Main {

    public static void main(String[] args) throws Exception {
        int line = 0;
        while (readLine()) line++;
        System.out.print(line);
    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static boolean readLine() throws Exception {
        if (idx == size) {
            idx = -1;
            size = System.in.read(buf, 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        while (buf[++idx] > 10);
        return buf[idx++] > 0;
    }

}
