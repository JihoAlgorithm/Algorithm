package boj18258;

class QueueImplementSimple {

    static int[] queue;
    static int head, tail;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        int N = read();
        queue = new int[N];
        sb = new StringBuilder();

        while (N-- > 0) {
            int op = System.in.read();
            if (op == 'p') op = System.in.read();
            read();
            switch (op) {
                case 'u': push(); continue;
                case 'o': pop(); break;
                case 's': size(); break;
                case 'e': empty(); break;
                case 'f': front(); break;
                case 'b': back(); break;
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static void push() throws Exception {
        queue[head++] = read();
    }

    static void pop() {
        sb.append(head == tail ? -1 : queue[tail++]);
    }

    static void size() {
        sb.append(head - tail);
    }

    static void empty() {
        sb.append(head == tail ? 1 : 0);
    }

    static void front() {
        sb.append(head == tail ? -1 : queue[tail]);
    }

    static void back() {
        sb.append(head == tail ? -1 : queue[head - 1]);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
