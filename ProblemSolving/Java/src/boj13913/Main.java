package boj13913;

import java.util.ArrayDeque;

class Main {

    static int N, K;

    static class Node {
        int x;
        Node prev;
        Node(int x, Node prev) {
            this.x = x;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws Exception {

        N = read();
        K = read();

        if (N >= K) {
            subinGoBack();
            return;
        }

        final int MAX = K + 1;
        Node subinNode = null;

        boolean[] visited = new boolean[MAX + 1];
        ArrayDeque<Node> queue = new ArrayDeque<>();

        visited[N] = true;
        queue.offer(new Node(N, null));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.x == K) {
                subinNode = node;
                break;
            }

            int x = node.x + 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                queue.offer(new Node(x, node));
            }

            x = node.x - 1;
            if (x >= 0 && !visited[x]) {
                visited[x] = true;
                queue.offer(new Node(x, node));
            }

            x = node.x << 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                queue.offer(new Node(x, node));
            }

        }

        ArrayDeque<Integer> path = new ArrayDeque<>();
        for (; subinNode.prev != null; subinNode = subinNode.prev)
            path.offer(subinNode.x);

        int time = path.size();
        StringBuilder sb = new StringBuilder();
        sb.append(time).append('\n').append(subinNode.x).append(' ');
        
        while (!path.isEmpty())
            sb.append(path.pollLast()).append(' ');

        System.out.print(sb);

    }

    static void subinGoBack() {
        StringBuilder sb = new StringBuilder();
        sb.append(N - K).append('\n');
        while (N >= K) sb.append(N--).append(' ');
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
