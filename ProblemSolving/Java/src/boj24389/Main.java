package boj24389;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = ~N + 1;
        int count = 0;

        for (int i = 0; i < 32; i++)
            count += (N & (1 << i)) == (M & (1 << i)) ? 0 : 1;

        System.out.print(count);
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}
