package boj9019;

class Parent {

    static final int MAX = 10_000;
    static final char D = 'D', S = 'S', L = 'L', R = 'R';

    static StringBuilder answer;

    static int[] parent;
    static char[] operator;
    static boolean[] visited;

    static final int MASK = (1 << 12) - 1;
    static int[] queue;
    static int head, tail;

    public static void main(String[] args) throws Exception {

        int T = read();
        answer = new StringBuilder();

        queue = new int[MASK + 1];
        parent = new int[MAX];
        operator = new char[MAX];

        while (T-- > 0) bfs(read(), read());

        System.out.print(answer);

    }

    static final int BUFFER_SIZE = 14;
    static int bufferIndex = 0;
    static char[] buffer = new char[BUFFER_SIZE];

    static void bfs(int number, int target) {
        visited = new boolean[MAX];
        head = tail = -1;

        visited[number] = true;
        queue[++head] = number;

        while (head > tail) {

            int n = queue[++tail & MASK];

            run(D, n, (n << 1) % MAX);
            run(S, n, n == 0 ? 9999 : n - 1);
            run(L, n, n % 1000 * 10 + n / 1000);
            run(R, n, n / 10 + n % 10 * 1000);

            if (visited[target]) {
                bufferIndex = BUFFER_SIZE;
                while (target != number) {
                    buffer[--bufferIndex] = operator[target];
                    target = parent[target];
                }
                answer
                    .append(buffer, bufferIndex, BUFFER_SIZE - bufferIndex)
                    .append('\n');
                return;
            }

        }
    }

    static void run(char o, int p, int n) {
        if (visited[n]) return;
        visited[n] = true;
        parent[n] = p;
        operator[n] = o;
        queue[++head & MASK] = n;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
