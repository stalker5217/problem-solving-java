package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _87946 {
	class Solution {
		private int initFatigue;
		private int[][] dungeons;
		private int answer;

		public int solution(int k, int[][] d) {
			initFatigue = k;
			dungeons = d;
			answer = 0;
			int size = dungeons.length;
			List<Integer> order = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				order.add(i);
			}
			permutation(order, 0);

			return answer;
		}

		private void permutation(List<Integer> order, int pos) {
			if (order.size() == pos) {
				int fatigue = initFatigue;
				int cnt = 0;
				for(int index : order) {
					if (fatigue >= dungeons[index][0]) {
						fatigue -= dungeons[index][1];
						cnt++;
					}
				}

				if (answer < cnt) {
					answer = cnt;
				}

				return;
			}

			for (int i = pos; i < order.size(); i++) {
				Collections.swap(order, i, pos);
				permutation(order, pos + 1);
				Collections.swap(order, i, pos);
			}
		}
	}
}
