package LEETCODE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _692 {
	private static class Solution {
		public List<String> topKFrequent(String[] words, int k) {
			Map<String, Integer> freqMap = new HashMap<>();
			for (String word : words) {
				if (freqMap.containsKey(word)) {
					freqMap.put(word, freqMap.get(word) + 1);
				} else {
					freqMap.put(word, 1);
				}
			}

			PriorityQueue<WordFreq> pq = new PriorityQueue<>((a, b) -> {
				if (a.frequency == b.frequency) {
					return a.word.compareTo(b.word);
				}

				return b.frequency - a.frequency;
			});
			for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
				pq.add(new WordFreq(entry.getValue(), entry.getKey()));
			}

			List<String> answer = new ArrayList<>();
			while (k-- > 0) {
				answer.add(pq.poll().word);
			}

			return answer;
		}

		private static class WordFreq {
			public int frequency;
			public String word;

			public WordFreq(int frequency, String word) {
				this.frequency = frequency;
				this.word = word;
			}
		}
	}
}
