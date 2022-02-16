package boj1874;

class Main {

    public static void main(String[] args) throws Exception {

        int n = read();
        int[] stack = new int[n];
        int pushIndex = 0;
        int top = -1;
        StringBuilder sb = new StringBuilder();
        final String PUSH = "+\n", POP = "-\n";

        for (int i = 0; i < n; i++) {
            int k = read();
            while (pushIndex < k) {
                stack[++top] = ++pushIndex;
                sb.append(PUSH);
            }
            if (stack[top--] != k) {
                pushIndex = -1;
                break;
            };
            sb.append(POP);
        }

        if (pushIndex == n) {
            while (top-- > -1) sb.append(POP);
            System.out.print(sb);
        } else
            System.out.println("NO");

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
