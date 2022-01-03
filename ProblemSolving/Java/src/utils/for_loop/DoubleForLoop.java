package utils.for_loop;

public class DoubleForLoop {

    private static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        int full = 0;
        int half = 0;
        for (int i = 0; i < 100; i++) {
            long f = full();
            long h = half();
            System.out.println("full : " + (f * 1e-9));
            System.out.println("half : " + (h * 1e-9));
            System.out.println("f - h = " + (f - h) * 1e-9 + " sec");
            if (f < h) full++;
            else half++;
        }
        System.out.println("full " + full + " / half " + half);
    }

    private static long full() {
        final long start = System.nanoTime();
        int[][] map = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 1;
            }
        }
        final long end = System.nanoTime();
        
        return end - start;
    }

    private static long half() {
        final long start = System.nanoTime();
        int[][] map = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                map[i][j] = map[j][i] = 1;
            }
        }
        final long end = System.nanoTime();
        
        return end - start;
    }

}

