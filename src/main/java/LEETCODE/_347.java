package LEETCODE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _347 {
	private static class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> freqMap = new HashMap<>();
			for (int num : nums) {
				int count = freqMap.getOrDefault(num, 0) + 1;
				freqMap.put(num, count);
			}

			Queue<ValueFrequency> pq = new PriorityQueue<>(Comparator.comparingInt(ValueFrequency::getFreq).reversed());
			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				pq.add(new ValueFrequency(entry.getKey(), entry.getValue()));
			}

			int[] answer = new int[k];
			for(int i = 0 ; i < k ; i++) {
				answer[i] = pq.poll().getValue();
			}

			return answer;
		}

		private static class ValueFrequency {
			public int value;
			public int freq;

			public ValueFrequency(int value, int freq) {
				this.value = value;
				this.freq = freq;
			}

			public int getValue() {
				return value;
			}

			public int getFreq() {
				return freq;
			}
		}
	}
}
