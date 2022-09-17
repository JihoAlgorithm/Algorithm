package pgms12927;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(works.length);
        pq.addAll(java.util.Arrays.stream(works).map(work -> -work).boxed().collect(Collectors.toList()));

        IntStream.range(0, n).forEach(i -> {
            if (!pq.isEmpty()) {
                int work = pq.poll();
                if (work < -1) pq.offer(work + 1);
            }
        });

        return pq.stream().mapToInt(work -> work * work).sum();

    }

}
