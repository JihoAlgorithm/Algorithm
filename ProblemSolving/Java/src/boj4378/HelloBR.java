package boj4378;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class HelloBR {

    static char[] qwerty = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./".toCharArray();
    static Map<Character, Character> mapper = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < qwerty.length; i++) mapper.put(qwerty[i], qwerty[i - 1]);

        while (true) {
            String str = br.readLine();
            if (str == null) break;

            char[] line = str.toCharArray();

            for (int i = 0; i < line.length; i++) {
                if (mapper.containsKey(line[i]))
                    line[i] = mapper.get(line[i]);
            }

            bw.write(line);
            bw.newLine();
        }

        bw.flush();
    }

}
