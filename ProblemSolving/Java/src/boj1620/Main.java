package boj1620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] pokemonName = new String[N + 1];
        Map<String, Integer> pokemonNumber = new HashMap<>();
        String name;

        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            pokemonName[i] = name;
            pokemonNumber.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            name = br.readLine();
            try {
                int number = Integer.parseInt(name);
                sb.append(pokemonName[number]).append('\n');
            } catch (Exception e) {
                sb.append(pokemonNumber.get(name)).append('\n');
            }
        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
