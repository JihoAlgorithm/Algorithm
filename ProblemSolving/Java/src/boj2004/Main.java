package boj2004;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int two = countTwo(N) - countTwo(N - M) - countTwo(M);
        int five = countFive(N) - countFive(N - M) - countFive(M);

        System.out.print(Math.min(two, five));

    }

    static int countTwo(int n) {
        int count = 0;
        while ((n >>= 1) > 0) count += n;
        return count;
    }

    static int countFive(int n) {
        int count = 0;
        while ((n /= 5) > 0) count += n;
        return count;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
