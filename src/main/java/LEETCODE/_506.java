package LEETCODE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _506 {
    private static class Solution {
        public String[] findRelativeRanks(int[] score) {
            List<Athlete> athleteList = Arrays.stream(score)
                    .boxed()
                    .sorted((a, b) -> Integer.compare(b, a))
                    .map(Athlete::new)
                    .toList();

            AtomicInteger current = new AtomicInteger(1);
            athleteList.forEach(a -> a.rank = current.getAndIncrement());

            Map<Integer, Athlete> athleteMap = athleteList.stream()
                    .collect(Collectors.toMap(
                            Athlete::getScore,
                            Function.identity()
                    ));

            return Arrays.stream(score)
                    .mapToObj(s -> {
                        int rank = athleteMap.get(s).rank;
                        if (rank == 1) {
                            return "Gold Medal";
                        } else if (rank == 2) {
                            return "Silver Medal";
                        } else if (rank == 3) {
                            return "Bronze Medal";
                        } else {
                            return String.valueOf(rank);
                        }
                    })
                    .toArray(String[]::new);
        }

        private static class Athlete {
            int score;
            int rank;

            public Athlete(int score) {
                this.score = score;
            }

            public int getScore() {
                return score;
            }
        }
    }
}
