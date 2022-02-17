package boj17298;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) A[i] = read();

        int[] stack = new int[N];
        int top = -1;
        for (int i = 0; i < N; i++) {
            while (top >= 0 && A[stack[top]] < A[i]) A[stack[top--]] = A[i];
            stack[++top] = i;
        }

        while (top >= 0) A[stack[top--]] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(A[i]).append(' ');
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
