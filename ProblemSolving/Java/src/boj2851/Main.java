package boj2851;

class Main {

    public static void main(String[] args) throws Exception {

        int[] mushrooms = new int[11];
        for (int i = 1; i < 11; i++) mushrooms[i] = mushrooms[i - 1] + read();
        for (int i = 1; i < 11; i++) mushrooms[i] = Math.abs(mushrooms[i] - 100);

        for (int i = 10; i > 0; i--) {
            if (mushrooms[i] <= mushrooms[i - 1]) {
                System.out.println(mushrooms[i] + 100);
                break;
            }
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
