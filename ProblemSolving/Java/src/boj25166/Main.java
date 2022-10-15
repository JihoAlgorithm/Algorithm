package boj25166;

class Main {
    public static void main(String[] args) throws Exception {
        int S = read();
        int M = read();

        if (S < 1024)
            System.out.println("No thanks");
        else {
            int diff = Math.abs(S - 1023);
            System.out.print((diff & M) == diff ? "Thanks" : "Impossible");
        }
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
