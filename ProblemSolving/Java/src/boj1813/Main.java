package boj1813;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] says = new int[51];
        for (int i = 0; i < N; i++) says[read()]++;
        System.out.print(getMaxTruth(N, says));
    }

    static int getMaxTruth(int N, int[] says) {
        for (int i = N; i >= 0; i--)
            if (i == says[i]) return i;
        return -1;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
