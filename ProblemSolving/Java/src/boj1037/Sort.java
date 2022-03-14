package boj1037;

class Sort {

    public static void main(String[] args) throws Exception {

        int num = read();
        int[] factor = new int[num];

        for (int i = 0; i < num; i++) factor[i] = read();
        java.util.Arrays.sort(factor);

        int N = 0;
        if ((num & 1) == 0) {
            N = factor[0] * factor[num - 1];
        } else {
            N = (int) Math.pow(factor[num >> 1], 2);
        }
        System.out.println(N);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
