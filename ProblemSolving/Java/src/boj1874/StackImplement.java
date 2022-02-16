package boj1874;

class StackImplement {
    public static void main(String[] args) throws Exception {
        int n = read();
        int number = 0;
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            int k = read();
            while (number < k) stack.push(++number);
            if (stack.isImpossible(k)) {
                number = 0;
                break;
            };
        }

        System.out.print(number == n ? stack.answer() : "NO");

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

class Stack {
    int top;
    int[] stack;
    StringBuilder sb;
    final String PUSH = "+\n";
    final String POP = "-\n";
    Stack(int size) {
        top = -1;
        stack = new int[size];
        sb = new StringBuilder();
    }
    boolean isImpossible(int k) {
        if (stack[top] != k) return true;
        this.pop();
        return false;
    }
    void push(int k) {
        sb.append(PUSH);
        stack[++top] = k;
    }
    int pop() {
        sb.append(POP);
        return stack[top--];
    }
    String answer() {
        while (top-- > -1) sb.append(POP);
        return sb.toString();
    }
}
