package boj21553;

class Main {

    public static void main(String[] args) throws Exception {
        byte[] P = new byte[100];
        while (System.in.read() > 32);
        System.out.write(P, 0, System.in.read(P, 0, 100));
    }

}
