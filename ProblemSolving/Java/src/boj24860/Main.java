package boj24860;

class Main {

    public static void main(String[] args) throws Exception {

        int lightChain = read() * read() + read() * read();
        int heavyChain = read() * read() * read();

        System.out.println(heavyChain * lightChain);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
