package wanted.test;

import java.util.ArrayList;
import java.util.List;

class A {

    static int maxSave = 0;
    static int N, K, A[], P[];
    static List<Town> towns;

    static class Town {
        int damage;
        int people;
    }

    public static void main(String[] args) throws Exception {

        N = nextInt();
        K = nextInt();
        A = new int[N];
        P = new int[N];

        towns = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            Town town = new Town();
            town.damage = nextInt();
            towns.add(town);
        }

        for (int i = 0; i < N; i++) {
            Town town = towns.get(i);
            town.people = nextInt();
        }

        towns.sort((a, b) -> {
            return a.people == b.people
                ? a.damage - b.damage
                : a.people - b.people;
        });

        for (int i = 0; i < N; i++) fight(K, 0, i, 0);

        System.out.print(maxSave);

    }

    static void fight(int k, int save, int cnt, int damage) {
        if (k < 0) return;
        if (maxSave < save) maxSave = save;

        for (int i = cnt; i < N; i++) {
            Town town = towns.get(i);
            fight(k - (damage + town.damage), save + town.people, i + 1, damage + town.damage);
        }
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
