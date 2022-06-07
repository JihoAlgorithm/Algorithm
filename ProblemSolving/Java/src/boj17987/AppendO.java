package boj17987;

class AppendO {

    public static void main(String[] args) throws Exception {

        final int SIZE = 1 << 11;
        byte[] howl = new byte[SIZE];
        int len = 0;

        while (true) {
            len = System.in.read(howl, 0, SIZE);
            if (len < SIZE) {
                howl[len - 1] = 'O';
                break;
            } else {
                System.out.write(howl);
            }
        }

        System.out.write(howl, 0, len);

    }

}
