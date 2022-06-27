package boj21313;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int SIZE = N << 1;
        int hand = 0;
        byte[] ganggangsullae = new byte[SIZE + 2];

        while (hand + 2 < SIZE) {
            ganggangsullae[hand++] = 49;
            ganggangsullae[hand++] = 32;
            ganggangsullae[hand++] = 50;
            ganggangsullae[hand++] = 32;
        }

        if ((N & 1) == 1) {
            ganggangsullae[hand++] = 51;
            ganggangsullae[hand++] = 32;
        }

        System.out.write(ganggangsullae, 0, hand - 1);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
