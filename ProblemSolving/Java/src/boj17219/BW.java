package boj17219;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class BW {

    static final int MAX = 1 << 14;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        int N = in.nextInt();
        int M = in.nextInt();

        Map<String, String> map = new HashMap<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (N-- > 0)
            map.put(in.next(), in.next());

        char[] buffer = new char[MAX];
        int i = 0;

        while (M-- > 0) {
            char[] password = map.get(in.next()).toCharArray();
            if (i + password.length >= MAX) {
                bw.write(buffer, 0, i);
                i = 0;
            }
            for (int s = 0; s < password.length; s++)
                buffer[i++] = password[s];
            buffer[i++] = 10;
        }

        bw.write(buffer, 0, i);
        bw.close();

    }

    static class Reader {
        static final int BUFFER_SIZE = 1 << 14;
        static final int MAX_SITE_LENGTH = 20;

        byte[] buffer;
        byte[] site;
        int index, len, siteIndex;

        Reader() {
            buffer = new byte[BUFFER_SIZE];
            site = new byte[MAX_SITE_LENGTH];
        }

        int nextInt() throws Exception {
            int n = 0;
            byte c;

            while ((c = read()) <= 32);

            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));

            return n;
        }

        String next() throws Exception {
            byte c;
            while ((c = read()) <= 32);

            siteIndex = 0;
            do site[siteIndex++] = c;
            while ((c = read()) > 32);

            return new String(site, 0, siteIndex);
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == len) {
                len = System.in.read(buffer, index = 0, BUFFER_SIZE);
                if (len == -1) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }

}
