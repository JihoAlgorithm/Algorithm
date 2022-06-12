package boj10219;

class Main {

    public static void main(String[] args) throws Exception {

        byte[][] grill = new byte[11][12];
        int i = 0, H, W, T = read();

        while (T-- > 0) {
            H = read();
            W = read() + 1;

            while (i < H) {
                System.in.read(grill[i++], 0, W);
            }

            while (i > 0) {
                System.out.write(grill[--i], 0, W);
            }
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
