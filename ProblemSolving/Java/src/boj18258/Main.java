package boj18258;

import java.util.LinkedList;
import java.util.Queue;

/** Time Limit Exceeded */
class Main {

    enum Command { PUSH, POP, SIZE, EMPTY, FRONT, BACK }

    public static void main(String[] args) throws Exception {

        int N = read();
        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            switch(readCommand()) {
                case PUSH:
                    queue.offer(read());
                    continue;
                case POP:
                    sb.append(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case SIZE:
                    sb.append(queue.size());
                    break;
                case EMPTY:
                    sb.append(queue.isEmpty() ? 1 : 0);
                    break;
                case FRONT:
                    sb.append(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case BACK:
                    sb.append(queue.isEmpty() ? -1 : queue.toArray()[queue.size() - 1]);
                    break;
            }

            sb.append('\n');

        }

        System.out.print(sb);

    }

    static Command readCommand() throws Exception {
        Command command;
        switch (System.in.read()) {
            case 'p':
                command = System.in.read() == 'u' ? Command.PUSH : Command.POP;
                break;
            case 's':
                command = Command.SIZE;
                break;
            case 'e':
                command = Command.EMPTY;
                break;
            case 'f':
                command = Command.FRONT;
                break;
            default:
                command = Command.BACK;
        }
        read();
        return command;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
