package boj1918;

class CleanUp {

    public static void main(String[] args) throws Exception {

        byte[] notation = new byte[100];
        int index = 0;
        int size = System.in.read(notation, 0, 100);

        int top = -1;
        byte[] stack = new byte[100];

        for (int i = 0; i < size; i++) {
            byte b = notation[i];
            if (b == 10) break;
            if (b < 65) {
                if (b == 41) {
                    while (top >= 0 && stack[top] != 40) {
                        notation[index++] = stack[top--];
                    }
                    top--;
                } else {
                    if (isMD(b) && top >= 0 && isMD(stack[top])) {
                        notation[index++] = stack[top--];
                    } else if (isPM(b)) {
                        while (top >= 0 && stack[top] != 40) {
                            notation[index++] = stack[top--];
                        }
                    }
                    stack[++top] = b;
                }
            } else {
                notation[index++] = b;
            }
        }

        while (top >= 0) notation[index++] = stack[top--];

        System.out.write(notation, 0, index);

    }

    static boolean isPM(byte o) {
        return o == 43 || o == 45;
    }

    static boolean isMD(byte o) {
        return o == 42 || o == 47;
    }

}
