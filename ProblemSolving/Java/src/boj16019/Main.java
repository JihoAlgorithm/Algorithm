package boj16019;

class Main {

    public static void main(String[] args) throws Exception {

        int[] numbers = new int[4];
        int[][] dist = new int[5][5];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            numbers[i] = read();
        }

        for (int i = 0; i <= 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                dist[i][j] = dist[j][i] = numbers[j - 1] + dist[i][j - 1];
            }
            for (int j = 0; j < 5; j++) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
