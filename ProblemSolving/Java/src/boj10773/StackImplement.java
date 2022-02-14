package boj10773;

class StackImplement {

    public static void main(String[] args) throws Exception {

        int K = read();
        int[] stack = new int[K];
        int top = -1;

        while (K-- > 0) {
            int number = read();
            if (number == 0) {
                top--;
            } else {
                stack[++top] = number;
            }
        }

        int sum = 0;
        while (top > -1) sum += stack[top--];

        System.out.println(sum);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
