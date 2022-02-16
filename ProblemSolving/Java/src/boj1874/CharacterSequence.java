package boj1874;

class CharacterSequence {

    static int[] stack;
    static int number, top;

    static char[] answer;
    static int answerIndex;
    static final char PUSH = '+', POP = '-', LINE_FEED = '\n';

    public static void main(String[] args) throws Exception {

        int n = read();
        stack = new int[n];
        answer = new char[n << 2];

        for (int i = 0; i < n; i++) {
            int k = read();
            while (number < k) push();
            if (stack[--top] != k) {
                System.out.print("NO");
                return;
            }
            pop();
        }

        while (top-- > 0) pop();
        System.out.print(answer);

    }

    static void push() {
        stack[top++] = ++number;
        answer[answerIndex++] = PUSH;
        answer[answerIndex++] = LINE_FEED;
    }

    static void pop() {
        answer[answerIndex++] = POP;
        answer[answerIndex++] = LINE_FEED;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
