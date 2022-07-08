package boj4378;

import java.util.HashMap;
import java.util.Map;

class Main {

    static char[] qwerty = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./".toCharArray();
    static Map<Character, Character> mapper = new HashMap<>();

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < qwerty.length; i++) mapper.put(qwerty[i], qwerty[i - 1]);
        while (read() >= 10);
        flush();
    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static byte read() throws Exception {
        if (size == idx) {
            flush();
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) return 0;
        }
        char c = (char) buf[idx];
        if (buf[idx] > 32)
            buf[idx] = (byte) mapper.get(c).charValue();
        return buf[idx++];
    }

    static void flush() {
        System.out.write(buf, 0, idx);
    }

}
