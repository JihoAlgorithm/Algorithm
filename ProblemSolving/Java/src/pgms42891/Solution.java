package pgms42891;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {3, 1, 2}, 5));
        System.out.println(new Solution().solution(new int[] {1, 1, 1, 1, 1}, 5));
    }

    public int solution(int[] food_times, long k) {

        List<Food> foods = new ArrayList<>();
        int length = food_times.length;

        for (int i = 0; i < length; i++) foods.add(new Food(i, food_times[i]));
        Collections.sort(foods, (a, b) -> a.time - b.time);

        int currentTime = 0;
        int index = 0;

        for (Food food : foods) {
            long diffTime = food.time - currentTime;
            if (diffTime > 0) {
                long duration = diffTime * length;
                if (k < duration) {
                    k %= length;
                    foods = foods.subList(index, food_times.length);
                    Collections.sort(foods, (a, b) -> a.index - b.index);
                    return foods.get((int) k).index + 1;
                } else {
                    currentTime = food.time;
                    k -= duration;
                }
            }
            index++;
            length--;
        }

        return -1;

    }

}

class Food {
    int index;
    int time;
    Food(int index, int times) {
        this.index = index;
        this.time = times;
    }
}
