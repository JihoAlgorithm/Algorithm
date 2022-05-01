package boj1043;

class UnionFind {

    static int[] set;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int knownNum = read();
        if (knownNum == 0) {
            System.out.print(M);
            return;
        }

        set = new int[N + 1];
        int highRank = ~(1 << 12);
        for (int i = 0; i <= N; i++) set[i] = -1;

        int[] people = null;
        boolean[] isKnown = new boolean[N + 1];
        for (int i = 0; i < knownNum; i++) {
            int known = read();
            isKnown[known] = true;
            set[known] = highRank;
        }

        int[][] parties = new int[M][];

        for (int i = 0; i < M; i++) {

            int peopleNum = read();
            people = parties[i] = new int[peopleNum];

            int host = people[0] = read();

            for (int j = 1; j < peopleNum; j++) {
                union(host, people[j] = read());
            }

        }

        int partyNum = M;
        for (int i = 0; i < M; i++) {

            people = parties[i];

            for (int j = 0; j < people.length; j++) {
                if (isKnown[find(people[j])]) {
                    partyNum--;
                    break;
                }
            }

        }

        System.out.print(partyNum);

    }

    static boolean union(int u, int v) {
        if ((u = find(u)) == (v = find(v))) return false;

        if (set[u] < set[v]) {
            set[u] += set[v];
            set[v] = u;
        } else {
            set[v] += set[u];
            set[u] = v;
        }

        return true;
    }

    static int find(int u) {
        return set[u] < 0 ? u : (set[u] = find(set[u]));
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
