package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _92341 {
	private static class Solution {
		public static int[] solution(int[] fees, String[] records) {
			Map<String, Time> inTimeMap = new HashMap<>();
			Map<String, Integer> timeMap = new HashMap<>();
			for (String record : records) {
				String[] infos = record.split(" ");
				String[] timeInfos = infos[0].split(":");

				Time time = new Time(Integer.parseInt(timeInfos[0]), Integer.parseInt(timeInfos[1]));

				if ("IN".equals(infos[2])) {
					inTimeMap.put(infos[1], time);
					continue;
				}

				int totalMinutes = getDiff(inTimeMap.get(infos[1]), time);
				inTimeMap.remove(infos[1]);
				timeMap.merge(infos[1], totalMinutes, Integer::sum);
			}

			for (String carNumber : inTimeMap.keySet()) {
				int totalMinutes = getDiff(inTimeMap.get(carNumber), new Time(23, 59));
				timeMap.merge(carNumber, totalMinutes, Integer::sum);
			}

			List<Integer> answer = new ArrayList<>();
			List<String> keyList = new ArrayList<>(timeMap.keySet());
			Collections.sort(keyList);
			for (String key : keyList) {
				int totalFee = fees[1];
				int totalMinutes = timeMap.get(key);
				int remainMinutes = totalMinutes - fees[0];
				if (remainMinutes > 0) {
					totalFee += (((remainMinutes - 1) / fees[2]) + 1)  * fees[3];
				}

				answer.add(totalFee);
			}

			return answer.stream().mapToInt(c -> c).toArray();
		}

		private static int getDiff(Time in, Time out) {
			return (out.hour - in.hour) * 60 + (out.minutes - in.minutes);
		}

		private static class Time {
			public int hour;
			public int minutes;

			public Time(int hour, int minutes) {
				this.hour = hour;
				this.minutes = minutes;
			}
		}
	}
}
