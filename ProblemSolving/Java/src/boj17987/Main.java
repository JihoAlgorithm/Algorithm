package boj17987;

class Main {

    public static void main(String[] args) throws Exception {

        int fenrirHowl = listen();
        byte[] howl = new byte[fenrirHowl + 3];

        for (int i = 0; i < fenrirHowl;) {
            howl[i++] = 'A';
            howl[i++] = 'W';
        }

        howl[fenrirHowl] = 'H';
        howl[fenrirHowl + 1] = howl[fenrirHowl + 2] = 'O';

        System.out.write(howl);

    }

    static int listen() throws Exception {
        int l = 0;
        while (System.in.read() > 32) l++;
        return l;
    }

}
