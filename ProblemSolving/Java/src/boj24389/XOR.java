package boj24389;

public class XOR {
    public static void main(String[] args) throws Exception {
        int N = read();
        System.out.println(
            Integer.toBinaryString(N ^ (~N + 1)).chars().filter(c -> c == 49).count()
        );
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}
