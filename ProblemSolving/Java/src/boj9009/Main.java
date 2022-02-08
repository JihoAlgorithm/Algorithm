package boj9009;

public class Main {

    private static final int MAX_INDEX = 45;
    private static int[] fibonacci = new int[MAX_INDEX];
    private static int[] numbers = new int[MAX_INDEX];

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        setFibonacci();

        int T = read();
        while (T-- > 0) {
            int k = read();
            if (k == 0) {
                sb.append(0).append('\n');
                continue;
            }
            int i = 0, maxIndex = lowerBound(k);
            while (maxIndex-- > 0) {
                if (k < fibonacci[maxIndex]) continue;
                k -= fibonacci[maxIndex];
                numbers[i++] = fibonacci[maxIndex];
            }
            while (i-- > 1) {
                sb.append(numbers[i - 1]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static void setFibonacci() {
        int a = 0, b = 1, i = 0;
        fibonacci[i++] = a;
        fibonacci[i++] = b;
        while (a + b < 1_000_000_000) {
            b = a + b;
            a = b - a;
            fibonacci[i++] = b;
        }
    }

    private static int lowerBound(int k) {
        int l = 0, r = MAX_INDEX, m;
        while (l < r)
            if (k > fibonacci[m = l + r >> 1]) l = m + 1;
            else r = m;
        return r == MAX_INDEX ? MAX_INDEX : r + 1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
