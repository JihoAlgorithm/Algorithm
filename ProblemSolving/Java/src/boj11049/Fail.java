package boj11049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Fail {

    static class Node implements Comparable<Node> {
        int v;
        int i;
        Node(int v, int i) {
            this.v = v;
            this.i = i;
        }
        @Override
        public int compareTo(Node o) {
            return o.v - this.v;
        }
    }

    static int[] matrix;
    static boolean[] visited;
    static PriorityQueue<Node> heap;
    static List<Node> temp;

    public static void main(String[] args) throws Exception {

        int N = read();

        matrix = new int[N + 1];
        visited = new boolean[N + 1];
        heap = new PriorityQueue<>(N);
        temp = new ArrayList<>(N);

        matrix[0] = read();
        for (int i = 1; i < N; i++) {
            matrix[i] = read();
            heap.offer(new Node(read(), i));
        }
        matrix[N] = read();

        int sum = 0;

        while (--N > 0) {

            Node node = getNode();
            visited[node.i] = true;

            int l = getIndex(node.i - 1, -1);
            int r = getIndex(node.i + 1, 1);

            sum += matrix[l] * node.v * matrix[r];

        }

        System.out.println(sum);

    }

    static Node getNode() {
        if (!temp.isEmpty()) return temp.remove(0);
        Node node = heap.poll();
        temp.add(node);
        while (!heap.isEmpty() && heap.peek().v == node.v) temp.add(heap.poll());
        Collections.sort(temp, (a, b)-> {
            int al = getIndex(a.i - 1, -1);
            int ar = getIndex(a.i + 1, 1);
            int bl = getIndex(b.i - 1, -1);
            int br = getIndex(b.i + 1, 1);

            int av = matrix[al] * a.v * matrix[ar];
            int bv = matrix[bl] * b.v * matrix[br];
            return av - bv;
        });
        return temp.remove(0);
    }

    static int getIndex(int i, int n) {
        while (visited[i]) i += n;
        return i;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
