package PROGRAMMERS.LEVEL_2;

public class _92342 {
	private class Solution {
		private int[] ryan;
		private int[] apeach;
		private int[] answer;
		private int diffMax = -1;

		public int[] solution(int n, int[] info) {
			ryan = new int[11];
			apeach = info;
			solve(n, 0);

			if (diffMax == -1) {
				return new int[] {-1};
			}

			return answer;
		}

		private void solve(int remain, int idx) {
			if (idx == 11 || remain == 0) {
				ryan[10] += remain;

				int ryanScore = 0;
				int apeachScore = 0;
				for (int i = 0; i < 11; i++) {
					if (ryan[i] > apeach[i]) {
						ryanScore += (10 - i);
					} else if (apeach[i] > 0) {
						apeachScore += (10 - i);
					}
				}

				int diff = ryanScore - apeachScore;
				if (diff > 0 && diff >= diffMax) {
					if (diff > diffMax || answerChange(answer, ryan)) {
						answer = ryan.clone();
					}

					diffMax = diff;
				}

				ryan[10] -= remain;

				return;
			}

			if (remain > apeach[idx]) {
				int useArrow = apeach[idx] + 1;

				ryan[idx] += useArrow;
				solve(remain - useArrow, idx + 1);
				ryan[idx] -= useArrow;
			}

			solve(remain, idx + 1);
		}

		private boolean answerChange(int[] answer, int[] ryan) {
			for (int i = 10; i >= 0; i--) {
				if (answer[i] < ryan[i]) {
					return true;
				} else if (answer[i] > ryan[i]) {
					return false;
				}
			}

			return false;
		}
	}
}
