package boj24798;

class Main {

    public static void main(String[] args) throws Exception {

        int l = read();
        int w = read();

        if (l > w || l * 26 < w) {
            System.out.print("impossible");
            return;
        }

        byte[] word = new byte[l];
        int offset = (int) (w / l + 1);

        for (int i = 0; i < l; i++) {
            word[i] = (byte) (offset | 96);
        }

        for (int i = offset * l; i > w; i--) {
            word[i % l]--;
        }

        System.out.write(word);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
