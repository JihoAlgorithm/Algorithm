package boj24578;

class Main {

    public static void main(String[] args) throws Exception {
        int time = read();
        char[][] bits = new char[4][4];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int t = time / (int) Math.pow(10, 3 - i) % 10;
            for (int k = 0; k < 4; k++) {
                bits[i][k] = (t & (1 << k)) != 0 ? '*' : '.';
            }
        }

        for (int i = 3; i >= 0; i--) {
            sb.append(bits[0][i]).append(' ')
                .append(bits[1][i]).append("   ")
                .append(bits[2][i]).append(' ')
                .append(bits[3][i]).append('\n');
        }

        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }

}
