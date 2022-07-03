package boj12866;

class Main {

    public static void main(String[] args) throws Exception {

        int L = read();
        byte[] nucleicSequence = new byte[L];
        int[] nucleics = new int[4];

        System.in.read(nucleicSequence);
        while (L-- > 0) {
            switch(nucleicSequence[L]) {
            case 'A': nucleics[0]++; break;
            case 'C': nucleics[1]++; break;
            case 'G': nucleics[2]++; break;
            case 'T': nucleics[3]++; break;
            }
        }

        long kind = 1;
        for (int i = 0; i < 4; i++) {
            kind *= nucleics[i];
            kind %= 1_000_000_007;
        }

        System.out.print(kind);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
