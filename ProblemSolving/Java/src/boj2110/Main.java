package boj2110;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int C = read();

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) houses[i] = read();
        java.util.Arrays.sort(houses);

        int l = 1;
        int r = houses[N - 1] - houses[0];

        while (l <= r) {
            int range = l + r >> 1;
            int count = 1;
            int house = houses[0];

            for (int i = 1; i < N; i++) {
                if (house + range <= houses[i]) {
                    house = houses[i];
                    count++;
                }
            }

            if (count < C) {
                r = range - 1;
            } else {
                l = range + 1;
            }

        }

        System.out.print(r);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
