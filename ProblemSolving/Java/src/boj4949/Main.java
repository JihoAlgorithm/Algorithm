package boj4949;

class Main {

    static final int POINT = 46;
    static final int LEFT_PARENTHESE = 40, RIGHT_PARENTHESE = 41;
    static final int LEFT_BRACE = 91, RIGHT_BRACE = 93;
    static final String YES = "yes\n", NO = "no\n";

    public static void main(String[] args) throws Exception {

        int[] input = new int[100];
        int[] stack = new int[101];
        StringBuilder sb = new StringBuilder();

        while (true) {
            
            int c, len = 0, top = 0;

            while ((c = System.in.read()) > 13) input[len++] = c;

            if (len == 1 && input[0] == POINT) break;

            for (int i = 0; i < len; i++) {
                if (input[i] == LEFT_PARENTHESE || input[i] == LEFT_BRACE)
                    stack[++top] = input[i];
                else if (input[i] == RIGHT_PARENTHESE)
                    if (stack[top] == LEFT_PARENTHESE) top--;
                    else top = -1;
                else if (input[i] == RIGHT_BRACE)
                    if (stack[top] == LEFT_BRACE) top--;
                    else top = -1;
                if (top < 0) break;
            }

            sb.append(top == 0 ? YES : NO);

        }

        System.out.print(sb);

    }

}
