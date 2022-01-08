package boj5597;

class Main {

    public static void main(String[] args) throws Exception {

        int students = 0;
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 28; i++)
            students |= (1 << read());

        for (int i = 1; i < 31; i++)
            if ((students & (1 << i)) == 0)
                sb.append(i).append('\n');

        System.out.print(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
