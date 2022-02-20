package boj11866;

class Div10Example {

    static int ROUND = 1_000;

    public static void main(String[] args) {

        accuracyTest();

        int times = ROUND;
        int winCountA = 0;
        int winCountB = 0;
        for (int i = 0; i < times; i++) {
            int result = timeTest();
            if (result == 0) continue;
            if (result < 0) winCountA++;
            else winCountB++;
        }

        System.out.println();
        System.out.println("--------------");
        System.out.println("유효경기: " + (winCountA + winCountB));
        System.out.println("A 승: " + winCountA);
        System.out.println("B 승: " + winCountB);
        System.out.println(times + " 회 중 " + winCountB + " 회 빨랐음.");

    }

    static int timeTest() {
        long aStart, aEnd, bStart, bEnd;
        int number;

        // B - Shift Method 테스트
        number = 0;
        bStart = System.nanoTime();
        for (int i = 1; i <= ROUND; i++) {
            number += div10(i);
        }
        System.out.println(number);
        bEnd = System.nanoTime();

        // A - 기본 계산 테스트
        number = 0;
        aStart = System.nanoTime();
        for (int i = 1; i <= ROUND; i++) {
            number += i / 10;
        }
        System.out.println(number);
        aEnd = System.nanoTime();

        long aRunningTime = aEnd - aStart;
        long bRunningTime = bEnd - bStart;

        System.out.println("A: " + aRunningTime + " ns");
        System.out.println("B: " + bRunningTime + " ns");

        if (aRunningTime == bRunningTime) return 0;

        return aRunningTime < bRunningTime ? -1 : 1;
    }

    static void accuracyTest() {
        try {
            for (int i = 1; i <= ROUND; i++)
                if (div10(i) != i / 10)
                    throw new Exception(i + "부터 부정확함");
                else
                    System.out.print(i + "\t");
        } catch (Exception e) {
            System.out.println();
            System.out.println("--------------");
            System.err.println(e.getMessage());
        }
    }

    static int div10(int n) {
        int q = (n >> 1) + (n >> 2);
        // 다음 줄 처리하지 않으면 170부터 에러 발생
        q = q + (q >> 4);
        // 다음 줄 처리하지 않으면 2,410부터 에러 발생
        q = q + (q >> 8);
        // 다음 줄 처리하지 않으면 534,890부터 에러 발생
        q = q + (q >> 16);
        q = q >> 3;
        if (n > 9 + ((q << 2) + q << 1)) return q + 1;
        return q;
    }

}
