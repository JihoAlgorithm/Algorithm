package boj20240;

class PeopleSolution {

    public static void main(String[] args) throws Exception {
        int s = read();
        int k = (int) Math.sqrt(s);

        for (int a = 1; a <= k; a++) {
            int squareA = a * a;
            int b = (int) Math.sqrt(s - squareA);
            int squareB = b * b;
            if (squareA + squareB == s) {
                System.out.print(
                    new StringBuilder()
                        .append(0).append(' ').append(a).append('\n')
                        .append(b).append(' ').append(0).append('\n')
                        .append(a).append(' ').append(a + b).append('\n')
                        .append(a + b).append(' ').append(b)
                );
                return;
            }
        }

        System.out.println("Impossible");
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
