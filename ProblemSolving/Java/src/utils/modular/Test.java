package utils.modular;

class Test {

    public static void main(String[] args) {
        for (int i = 2000; i < 3000; i++) {
            int k = (i + 48) & 1023;
            int s = i % 1000;
            System.out.println("i: " + i + ", k: " + k + ", s: " + s);
        }
    }

}
