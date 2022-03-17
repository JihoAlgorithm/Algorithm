package boj1676;

class Loop {

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine());
        int count = 0;
        while ((N /= 5) > 0) count += N;
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.close();

    }

}
