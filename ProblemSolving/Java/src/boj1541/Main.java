package boj1541;

class Main {

    static int i;
    static byte[] buffer;

    public static void main(String[] args) throws Exception {

        buffer = new byte[51];
        i = -1;

        int size = System.in.read(buffer, 0, 50);
        int num = read();

        while (i < size) {
            if (buffer[i] == 45) break;
            num += read();
        }

        while (i < size) num -= read();

        System.out.print(num);

    }

    static int read() {
        int n = 0;
        while (buffer[++i] > 47)
            n = (n << 3) + (n << 1) + (buffer[i] & 15);
        return n;
    }

}
