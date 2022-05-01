package boj1043;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[] queue = new int[N];
        int head = -1, tail = -1;

        boolean[] isKnown = new boolean[N + 1];
        boolean[] isNotSafe = new boolean[M];

        for (int i = read(); i > 0; i--) {
            int person = read();
            queue[++head] = person;
            isKnown[person] = true;
        }

        int[][] participants = new int[M][];
        int[][] parties = new int[N + 1][M];
        int[] index = parties[0] = new int[N + 1];

        for (int party = 0; party < M; party++) {

            int num = read();
            participants[party] = new int[num];

            for (int i = 0; i < num; i++) {
                int person = read();
                participants[party][i] = person;
                parties[person][index[person]++] = party;
            }

        }

        while (head > tail) {

            int known = queue[++tail];

            for (int p = 0; p < index[known]; p++) {

                int party = parties[known][p];
                isNotSafe[party] = true;

                for (int i = 0; i < participants[party].length; i++) {
                    int newKnown = participants[party][i];

                    if (isKnown[newKnown]) continue;

                    isKnown[newKnown] = true;
                    queue[++head] = newKnown;
                }

            }

        }

        int party = 0;
        for (int i = 0; i < M; i++) {
            if (isNotSafe[i]) continue;
            party++;
        }

        System.out.print(party);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
