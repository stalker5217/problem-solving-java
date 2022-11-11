package LEETCODE;

public class _278 {
	private static class Solution extends VersionControl {
		public int firstBadVersion(int n) {
			int start = 0;
			int end = n;

			while(start <= end) {
				int mid = (end - start) / 2 + start;

				if (isBadVersion(mid)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			return start;
		}
	}

	private static class VersionControl {
		boolean isBadVersion(int version) {
			return true;
		}
	}
}
