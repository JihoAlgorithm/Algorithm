package boj2525;

class Main {

    public static void main(String[] args) throws Exception {

        int hour = read();
        int minute = read() + read();

        hour += minute / 60;
        minute %= 60;
        hour %= 24;

        System.out.print(
            new StringBuilder()
                .append(hour).append(' ').append(minute)
        );

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
