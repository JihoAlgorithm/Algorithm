package boj9019;

import java.util.ArrayDeque;

class Main {

    static boolean[] visited;
    static ArrayDeque<Node> queue;
    static Node node;

    static class Node {
        int number;
        ArrayDeque<Character> op;
        Node(int number, ArrayDeque<Character> op) {
            this.number = number;
            this.op = new ArrayDeque<>(op);
        }
        void offer(char o) {
            op.offer(o);
        }
        String getOperations() {
            StringBuilder sb = new StringBuilder();
            op.forEach(o -> sb.append(o.charValue()));
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {

        int T = read();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            int number = read();
            int target = read();

            visited = new boolean[10000];
            queue = new ArrayDeque<>();

            visited[number] = true;
            queue.offer(new Node(number, new ArrayDeque<>()));

            while (!queue.isEmpty()) {

                node = queue.poll();

                if (node.number == target) {
                    sb.append(node.getOperations()).append('\n');
                    break;
                }

                int num = node.number << 1;
                if (num > 9999) num %= 10000;
                if (!visited[num]) offer(num, 'D');

                num = node.number - 1;
                if (num < 0) num = 9999;
                if (!visited[num]) offer(num, 'S');

                num = (node.number % 1000) * 10 + node.number / 1000;
                if (!visited[num]) offer(num, 'L');

                num = (node.number / 10) + (node.number % 10) * 1000;
                if (!visited[num]) offer(num, 'R');

            }

        }

        System.out.print(sb);

    }

    static void offer(int num, char o) {
        visited[num] = true;
        node.op.offer(o);
        queue.offer(new Node(num, node.op));
        node.op.pollLast();
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
