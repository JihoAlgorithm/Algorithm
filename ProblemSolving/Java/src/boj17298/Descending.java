package boj17298;

class Descending {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] input = new int[N];
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) input[i] = read();

        int[] stack = new int[N];
        int top = -1;

        for (int i = N - 1; i >= 0; i--) {
            while (top >= 0 && stack[top] <= input[i]) top--;
            answer[i] = top >= 0 ? stack[top] : -1;
            stack[++top] = input[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(answer[i]).append(' ');
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
