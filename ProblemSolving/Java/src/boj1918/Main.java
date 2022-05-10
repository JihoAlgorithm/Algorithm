package boj1918;

class Main {

    public static void main(String[] args) throws Exception {

        byte[] infixNotation = new byte[100];
        int infixLength = System.in.read(infixNotation, 0, 100);

        int postfixLength = 0;
        byte[] postfixNotation = new byte[100];

        int top = -1;
        byte[] stack = new byte[100];

        for (int i = 0; i < infixLength; i++) {
            byte b = infixNotation[i];
            if (b == 10) continue;
            if (b < 65) {
                if (b == '(') {
                    stack[++top] = b;
                } else if (b == ')') {
                    while (top >= 0 && stack[top] != '(') {
                        postfixNotation[postfixLength++] = stack[top--];
                    }
                    top--;
                } else if (b == '*' || b == '/') {
                    if (top >= 0 && (stack[top] == '*' || stack[top] == '/')) {
                        postfixNotation[postfixLength++] = stack[top--];
                    }
                    stack[++top] = b;
                } else {
                    while (top >= 0 && stack[top] != '(') {
                        postfixNotation[postfixLength++] = stack[top--];
                    }
                    stack[++top] = b;
                }
            } else {
                postfixNotation[postfixLength++] = b;
            }
        }

        while (top >= 0) {
            postfixNotation[postfixLength++] = stack[top--];
        }

        System.out.write(postfixNotation, 0, postfixLength);
        System.out.close();

    }

}
