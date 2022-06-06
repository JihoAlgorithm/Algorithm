package boj16239;

class Main {

    public static void main(String[] args) throws Exception {

        int K = read();
        int N = read();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            sb.append(i).append('\n');
            K -= i;
        }

        sb.append(K);
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
