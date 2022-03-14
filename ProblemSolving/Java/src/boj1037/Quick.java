package boj1037;

class Quick {

    public static void main(String[] args) throws Exception {

        int size = read();
        int[] factor = getFactors(size);

        int N = 0;
        if ((size & 1) == 0)
            N = factor[0] * factor[size - 1];
        else
            N = (int) Math.pow(factor[size >> 1], 2);

        print(N);

    }

    static int[] getFactors(int size) throws Exception {
        int[] factor = new int[size];
        for (int i = 0; i < size; i++) factor[i] = read();
        quickSort(factor, 0, size - 1);
        return factor;
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m, r);
    }

    static int partition(int[] arr, int l, int r) {
        int p = arr[l + r >> 1];
        while (l <= r) {
            while (arr[l] < p) l++;
            while (arr[r] > p) r--;
            if (l <= r) swap(arr, l++, r--);
        }
        return l;
    }

    static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    static void print(int N) {
        try (
            java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(System.out);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(osw);
        ) {
            int len = (int) Math.log10(N) + 1;
            char[] buffer = new char[len];

            while (N > 0) {
                buffer[--len] = (char) (N % 10 | 48);
                N /= 10;
            }

            bw.write(buffer);
        } catch (Exception e) {}
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
