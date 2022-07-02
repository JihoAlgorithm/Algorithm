package boj17427;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i * (N / i);
        }

        System.out.print(sum);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
