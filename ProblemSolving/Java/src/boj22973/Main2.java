package boj22973;

class Main2 {

    public static void main(String[] args) throws Exception {
        long K = read();
        if (K == 0) {
            System.out.print(0);
        } else if ((K & 1) == 0) {
            System.out.print(-1);
        } else {
            int time = 0;
            while (K > 0) {
                time++;
                K >>= 1;
            }
            System.out.print(time);
        }
    }

    static long read() throws Exception {
        int c;
        long n = System.in.read() & 15;
        if (n == 13) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
