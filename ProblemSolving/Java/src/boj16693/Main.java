package boj16693;

class Main {

    static final double PI = 3.141592653589793;

    public static void main(String[] args) throws Exception {

        double slice = (double) read() / read();
        double whole = PI * pow(read()) / read();

        System.out.print(slice > whole ? "Slice of pizza" : "Whole pizza");

    }

    static int pow(int a) {
        return a * a;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
