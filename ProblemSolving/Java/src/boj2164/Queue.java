package boj2164;

class Queue {

    public static void main(String[] args) throws Exception {

        int N = read();

        if (N == 1) {
            System.out.print(1);
            return;
        }

        int half = N >> 1;
        int mask = (1 << 18) - 1;
        int[] queue = new int[mask + 1];
        int head = -1;
        int tail = half - 1;

        for (int i = 1; i <= half; i++) queue[i - 1] = i << 1;

        if ((N & 1) == 1) queue[++tail] = queue[++head];

        while (tail > ++head)
            queue[++tail & mask] = queue[++head & mask];

        System.out.print(queue[tail & mask]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
