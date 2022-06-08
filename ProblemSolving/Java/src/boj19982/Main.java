package boj19982;

class Main {

    public static void main(String[] args) throws Exception {

        int n = read();
        int a = read();
        int b = read();
        int c = read();

        int l = 0;
        byte[] password = new byte[n];

        for (int i = 0; i < a; i++) {
            password[l++] = (byte) (65 + (i % 26));
        }

        for (int i = 0; i < b; i++) {
            password[l++] = (byte) (97 + (i % 26));
        }

        n += c;
        n -= (a + b + c);

        for (int i = 0; i < n; i++) {
            password[l++] = (byte) (48 + (i % 10));
        }

        System.out.write(password);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
