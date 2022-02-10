package boj1174;

class ArrayQuickSort {

    static final int MAX_COUNT = 1 << 10;
    static int N;

    public static void main(String[] args) throws Exception {
        N = read();
        System.out.println(findDecreasingNumber());
    }

    static long findDecreasingNumber() {
        if (N < 12) return N - 1;
        if (N >= MAX_COUNT) return -1;
        return find();
    }

    static long find() {
        long[] numbers = new long[MAX_COUNT];

        for (int i = 1; i < MAX_COUNT; i++) {
            int count = i;
            for (int j = 9; j >= 0; j--) {
                if ((count & 1) != 0)
                    numbers[i] = (numbers[i] << 3) + (numbers[i] << 1) + j;
                count >>= 1;
            }
        }

        quickSort(numbers, 0, MAX_COUNT - 1);
        return numbers[N];
    }

    private static void quickSort(long[] arr, int l, int r) {

        if (l >= r) return;

        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m, r);

    }

    private static int partition(long[] arr, int l, int r) {

        long p = arr[l + r >> 1];

        while (l <= r) {

            while (arr[l] < p) l++;
            while (arr[r] > p) r--;

            if (l <= r) swap(arr, l++, r--);

        }

        return l;

    }

    private static void swap(long[] arr, int l, int r) {
        long n = arr[l];
        arr[l] = arr[r];
        arr[r] = n;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
