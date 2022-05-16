package boj3034;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        final String DA = "DA\n";
        final String NE = "NE\n";

        int N = read();
        double diagonal = Math.sqrt(Math.pow(read(), 2) + Math.pow(read(), 2));

        while (N-- > 0) sb.append(read() <= diagonal ? DA : NE);

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
