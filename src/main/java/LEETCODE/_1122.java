package LEETCODE;

import java.util.*;
import java.util.stream.Collectors;

public class _1122 {
    private static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> priorityMap = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                priorityMap.put(arr2[i], i);
            }

            return Arrays.stream(arr1)
                    .boxed()
                    .sorted((a, b) -> {
                        if (priorityMap.containsKey(a) && priorityMap.containsKey(b)) {
                            return priorityMap.get(a) - priorityMap.get(b);
                        } else if (priorityMap.containsKey(a)){
                            return -1;
                        } else if (priorityMap.containsKey(b)) {
                            return 1;
                        }

                        return Integer.compare(a, b);
                    })
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
