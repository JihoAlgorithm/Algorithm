package boj2470;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] solution = new int[N];

        for (int i = 0; i < N; i++) solution[i] = read();
        java.util.Arrays.sort(solution);

        int pointerL = 0;
        int pointerR = N - 1;

        int result = 2_000_000_000;
        int resultL = 0;
        int resultR = 0;

        while (pointerL < pointerR) {

            int mixedSolution = solution[pointerL] + solution[pointerR];
            if (mixedSolution == 0) {
                resultL = pointerL;
                resultR = pointerR;
                break;
            }

            int absValue = mixedSolution < 0 ? ~mixedSolution + 1 : mixedSolution;

            if (result > absValue) {
                result = absValue;
                resultL = pointerL;
                resultR = pointerR;
            }

            if (mixedSolution < 0) {
                pointerL++;
            } else {
                pointerR--;
            }

        }

        System.out.println(solution[resultL] + " " + solution[resultR]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
