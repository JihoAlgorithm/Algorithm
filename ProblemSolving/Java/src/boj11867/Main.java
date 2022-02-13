package boj11867;

class Main {

    public static void main(String[] args) throws Exception {
        boolean boxA = isEven();
        boolean boxB = isEven();
        System.out.println(boxA || boxB ? 'A' : 'B');
    }

    static boolean isEven() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return (n & 1) == 0;
    }

}
