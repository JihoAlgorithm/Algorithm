package wanted.test;

class C {

    public static void main(String[] args) throws Exception {

        int N = nextInt();

        long[] A = new long[N + 1];
        long[] B = new long[N + 1];

        for (int i = 1; i <= N; i++) A[i] = nextInt();
        for (int i = 1; i <= N; i++) B[i] = nextInt();

        SegmentTree treeA = new SegmentTree(N);
        SegmentTree treeB = new SegmentTree(N);

        treeA.init(A, 1, 1, N);
        treeB.init(B, 1, 1, N);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (treeA.sum(1, 1, N, i, j) == treeB.sum(1, 1, N, i, j)) {
                    answer++;
                }
            }
        }

        System.out.print(answer);

    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}

class SegmentTree {
    long tree[];
    int treeSize;

    public SegmentTree(int arrSize){
        int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

        this.treeSize = (int) Math.pow(2,h+1);
        tree = new long[treeSize];
    }

    public long init(long[] arr, int node, int start,int end){
        
        if(start == end){
            return tree[node] = arr[start];
        }

        return tree[node] = init(arr,node*2,start,(start+ end)/2) + init(arr,node*2+1,(start+end)/2+1,end);
    }

    public void update(int node, int start, int end, int idx, long diff){
        if(idx < start || end < idx) return;

        tree[node] += diff;

        if(start != end){
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    public long sum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        return sum(node*2, start, (start+end)/2, left, right)+
                sum(node*2+1, (start+end)/2+1, end, left, right);
    }
}
