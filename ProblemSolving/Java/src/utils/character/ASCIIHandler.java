package utils.character;

import java.util.ArrayList;

public class ASCIIHandler {

    private static ArrayList<Integer> input;

    public static void main(String[] args) {

        input = new ArrayList<>();
        read();
        input.stream().forEach(System.out::println);

    }

    private static void read() {
        try {
            int c;
            while ((c = System.in.read()) > 32) input.add(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
