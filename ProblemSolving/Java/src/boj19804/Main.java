package boj19804;

class Main {

    public static void main(String[] args) throws Exception {
        double R = read();
        double L = read();
        StringBuilder sb = new StringBuilder();

        if (2 * R <= L) {
            sb.append(-R).append(' ').append(0).append('\n');
            sb.append(R).append(' ').append(0);
        } else {
            double x = Math.sqrt(R * R * 4 - L * L);
            sb.append(x).append(' ').append(L / 2).append('\n');
            sb.append(x).append(' ').append(-L / 2);
        }

        System.out.print(sb);
    }

    static double read() throws Exception {
        int c, e = 1, f = 0, n = System.in.read() & 15;
        boolean point = false;
        while ((c = System.in.read()) > 32) {
            if (c == '.') {
                point = true;
            } else if (point) {
                e = (e << 3) + (e << 1);
                f = (f << 3) + (f << 1) + (c & 15);
            } else {
                n = (n << 3) + (n << 1) + (c & 15);
            }
        }
        return n + (double) f / e;
    }

}
