package boj20944;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        byte[] buf = new byte[N];
        for (int i = 0; i < N; i++) buf[i] = 97;
        System.out.write(buf);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
