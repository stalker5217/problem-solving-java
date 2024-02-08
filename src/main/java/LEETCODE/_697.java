package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _697 {
    private static class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, FreqInfo> freqMap = new HashMap<>();
            int maxFreq = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                FreqInfo current;
                if (freqMap.containsKey(nums[i])) {
                    current = freqMap.get(nums[i]);
                    current.end = i;
                    current.freq++;
                } else {
                    current = new FreqInfo();
                    current.start = i;
                    current.end = i;
                    current.freq = 1;
                }
                freqMap.put(nums[i], current);

                if (maxFreq < current.freq) {
                    result = current.end - current.start + 1;
                    maxFreq = current.freq;
                } else if (maxFreq == current.freq) {
                    result = Math.min(result, current.end - current.start + 1);
                }
            }

            return result;
        }

        private static class FreqInfo {
            int start;
            int end;
            int freq;
        }
    }
}
