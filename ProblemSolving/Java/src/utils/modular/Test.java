package utils.modular;

class Test {

    public static void main(String[] args) {
        for (int i = 999; i < 2000; i++) {
            int k = (i + 24) & 1023;
            int s = i % 1000;
            System.out.println("k: " + k + ", s: " + s);
        }
    }

}
