package boj10926;

class Main {

    public static void main(String[] args) throws Exception {

        byte[] buffer = new byte[50];
        byte[] dismay = new byte[] { '?', '?', '!' };
        System.out.write(buffer, 0, System.in.read(buffer) - 1);
        System.out.write(dismay);

    }

}
