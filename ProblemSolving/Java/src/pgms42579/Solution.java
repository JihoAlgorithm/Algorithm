package pgms42579;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    class Music {
        int i;
        int play;
        String genre;

        Music(int i, int play, String genre) {
            this.i = i;
            this.play = play;
            this.genre = genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(i, plays[i], genres[i]))
                .collect(Collectors.groupingBy(g -> g.genre))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().stream().mapToInt(m -> m.play).sum() - a.getValue().stream().mapToInt(m -> m.play).sum())
                .flatMap(k -> k.getValue().stream().sorted((a, b) -> b.play == a.play ? a.i - b.i : b.play - a.play).limit(2))
                .mapToInt(m -> m.i).toArray();
    }

    public static void main(String[] args) {
        int[] result = new Solution().solution(
                new String[] { "classic", "pop", "classic", "classic", "pop" },
                new int[] { 500, 600, 150, 800, 2500 }
        );
        assert result.equals(new int[] { 4, 1, 3, 0 });
    }

}
