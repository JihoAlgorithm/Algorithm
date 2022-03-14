package boj1037;

class Hack {

    public static void main(String[] args) throws Exception {
        int size = read();
        int min = 1_000_000;
        int max = 0;
        while (size-- > 0) {
            int num = read();
            if (min > num) min = num;
            if (max < num) max = num;
        }
        System.out.println(min * max);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
