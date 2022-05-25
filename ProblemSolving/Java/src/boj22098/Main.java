package boj22098;

class Main {

    static int[] numbers = new int[4];
    static int[] count = new int[3];

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();

        while (T-- > 0) {

            for (int i = 0; i < 4; i++) {
                numbers[i] = read();
            }

            check(0, 1, 2);
            check(0, 1, 3);
            check(0, 2, 3);
            check(1, 2, 3);

            for (int i = 0; i < 3; i++) {
                sb.append(count[i]).append(' ');
                count[i] = 0;
            }
            sb.append('\n');

        }

        System.out.print(sb);

    }

    static void check(int i, int j, int k) {
        int a, b, c, t;

        a = numbers[i];
        b = numbers[j];
        c = numbers[k];

        if (c < a) {
            t = a;
            a = c;
            c = t;
        }

        if (c < b) {
            t = b;
            b = c;
            c = t;
        }

        if (a + b <= c) return;

        a *= a;
        b *= b;
        c *= c;

        if (a + b == c) {
            count[0]++;
        } else if (a + b > c) {
            count[1]++;
        } else {
            count[2]++;
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
