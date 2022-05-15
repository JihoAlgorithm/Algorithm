package boj11478;

import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {

        byte[] string = new byte[1001];
        int size = System.in.read(string, 0, 1001) - 1;

        Set<String> set = new HashSet<>();
        for (int l = 1; l <= size; l++) {
            for (int s = 0; s < size; s++) {
                if (s + l > size) break;
                set.add(new String(string, s, l));
            }
        }

        System.out.print(set.size());

    }

}
