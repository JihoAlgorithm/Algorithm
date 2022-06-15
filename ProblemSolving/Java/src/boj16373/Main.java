package boj16373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    static int n;
    static List<List<Integer>> graph;
    static int[] tree, answer;
    static int minR;

    public static void main(String[] args) throws Exception {

        int testcase = nextInt();

        while (testcase-- > 0) {

            n = nextInt();
            graph = new ArrayList<>();
            tree = new int[n + 1];
            answer = new int[n + 1];
            minR = 1 << 28;

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                tree[i] = i;
            }

            for (int i = 1; i < n; i++) {
                int u = nextInt();
                int v = nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            permutation(1);

            System.out.println(Arrays.toString(answer));

        }

    }

    static void permutation(int depth) {
        if (depth > n) {
            int r = dfs(1, -1);
            if (minR > r) {
                minR = r;
                for (int i = 1; i <= n; i++) answer[i] = tree[i];
            }
            return;
        }
        for (int i = depth; i <= n; i++) {
            swap(depth, i);
            permutation(depth + 1);
            swap(depth, i);
        }
    }

    static void swap(int a, int b) {
        int t = tree[a];
        tree[a] = tree[b];
        tree[b] = t;
    }

    static int dfs(int curr, int prev) {
        int cnt = 0;
        for (int next : graph.get(curr)) {
            if (next != prev) {
                if (gcd(tree[curr], tree[next]) != 1) cnt++;
                cnt += dfs(next, curr);
                if (cnt >= minR) return 1 << 28;
            }
        }
        return cnt;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int oidx, iidx, size, SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 32);
        return n;
    }

    static byte read() throws Exception {
        if (iidx == size) {
            size = System.in.read(ibuf, iidx = 0, SIZE);
            if (size < 0) ibuf[0] = -1;
        }
        return ibuf[iidx++];
    }

}
