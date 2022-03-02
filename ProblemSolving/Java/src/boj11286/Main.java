package boj11286;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        Heap heap = new Heap(N);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int c = read();
            if (c == 0)
                sb.append(heap.poll()).append('\n');
            else
                heap.offer(c);
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}

class Heap {
    int size;
    int[] heap;
    Heap(int l) {
        heap = new int[l + 1];
    }
    void offer(int e) {
        heap[++size] = e;
        int i = size << 1;
        while ((i >>= 1) > 1)
            if (!swap(i)) break;
    }
    int poll() {
        if (size == 0) return 0;
        int e = heap[1];
        heap[1] = heap[size--];
        int i = 1;
        while ((i <<= 1) <= size) {
            if (i < size && compare(i + 1, i)) i++;
            if (!swap(i)) break;
        }
        return e;
    }
    boolean swap(int i) {
        int j = i >> 1;
        int p = heap[j];
        int c = heap[i];
        if (compare(j, i)) return false;
        heap[j] = c;
        heap[i] = p;
        return true;
    }
    boolean compare(int i, int j) {
        int a = heap[i];
        int b = heap[j];
        if (a < 0) a = ~a + 1;
        if (b < 0) b = ~b + 1;
        if (a == b) return heap[i] < heap[j];
        return a < b;
    }
}
