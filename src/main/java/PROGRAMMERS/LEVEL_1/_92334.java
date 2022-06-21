package PROGRAMMERS.LEVEL_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _92334 {
	public static void main(String[] args) {

	}

	static class Solution {
		public static int[] solution(String[] id_list, String[] report, int k) {
			Map<String, Set<String>> reportSet = new HashMap<>();
			Map<String, Integer> reportedCnt = new HashMap<>();

			for (String s : report) {
				String[] split = s.split(" ");
				final String reporter = split[0];
				final String target = split[1];

				reportSet.computeIfAbsent(reporter, v -> new HashSet<>());
				if (!reportSet.get(reporter).contains(target)) {
					reportSet.get(reporter).add(target);
					reportedCnt.putIfAbsent(target, 0);
					reportedCnt.put(target, reportedCnt.get(target) + 1);
				}
			}

			List<Integer> answer = new ArrayList<>();
			for (String id : id_list) {
				if (reportSet.containsKey(id)) {
					int cnt = 0;
					for (String target : reportSet.get(id)) {
						if (reportedCnt.get(target) >= k) {
							cnt++;
						}
					}
					answer.add(cnt);
				} else {
					answer.add(0);
				}
			}

			return answer.stream().mapToInt(c -> c).toArray();
		}
	}
}
