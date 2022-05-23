package boj20215;

class Main {

    public static void main(String[] args) throws Exception {

        int w = read();
        int h = read();

        int rectangle = w + h;
        double diagonal = Math.sqrt(w * w + h * h);

        System.out.print(rectangle - diagonal);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
