package boj9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        int inputSize = input.length;
        int bombSize = bomb.length;

        int top = 0;
        int index = 0;

        while (index < inputSize) {
            input[top++] = input[index];
            if (top >= bombSize) {
                int i = 1;
                for (; i <= bombSize; i++) {
                    if (input[top - i] != bomb[bombSize - i]) break;
                }
                if (i == bombSize + 1) {
                    for (i = 0; i < bombSize; i++) top--;
                }
            }
            index++;
        }

        if (top == 0) {
            System.out.println("FRULA");
        } else {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(input, 0, top);
            bw.close();
        }

    }

}
