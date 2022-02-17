package boj17298;

class NoStack {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] input = new int[N];
        int[] NGE = new int[N];

        for (int i = 0; i < N; i++) input[i] = read();

        int top = N;

        for (int i = N; i-- > 0;) {
            while (top < N && input[top] <= input[i]) top++;
            NGE[i] = top < N ? input[top] : -1;
            input[--top] = input[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(NGE[i]).append(' ');
        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
