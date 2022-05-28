package boj1905;

import java.util.ArrayList;
import java.util.List;

class Main {

    static class Box {

        int lx, ly, lz, px, py;

        Box(int lx, int ly, int lz, int px, int py) {
            this.lx = lx;
            this.ly = ly;
            this.lz = lz;
            this.px = px;
            this.py = py;
        }

    }

    public static void main(String[] args) throws Exception {

        next();
        next();
        int N = next();

        List<Box> boxes = new ArrayList<>(N);
        int height = 0;

        for (int i = 0; i < N; i++) {

            Box box = new Box(next(), next(), next(), next(), next());

            for (int j = i - 1; j >= 0; j--) {
                Box under = boxes.get(j);
                if (!isOut(box, under)) {
                    box.lz += under.lz;
                    break;
                }
            }

            if (height < box.lz) {
                height = box.lz;
            }

            boxes.add(lowerBound(0, i, box.lz, boxes), box);

        }

        System.out.print(height);

    }

    static boolean isOut(Box c, Box p) {
        return c.px >= p.px + p.lx || c.px + c.lx <= p.px || c.py >= p.py + p.ly || c.py + c.ly <= p.py;
    }

    static int lowerBound(int l, int r, int v, List<Box> boxes) {
        int m;
        while (l < r)
            if (boxes.get(m = l + r >> 1).lz < v) l = m + 1;
            else r = m;
        return r;
    }

    static final int SIZE = 1 << 13;
    static final byte[] buffer = new byte[SIZE];
    static int index, size;

    static int next() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

}
