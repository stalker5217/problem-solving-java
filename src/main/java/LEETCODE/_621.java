package LEETCODE;

public class _621 {
	private static class Solution {
		public int leastInterval(char[] tasks, int n) {
			int[] count = new int[26];
			int max = -1;
			int maxCount = 0;
			for (int cur : tasks) {
				int index = cur - 'A';
				count[index]++;

				if (count[index] > max) {
					max = count[index];
					maxCount = 1;
				} else if(count[index] == max) {
					maxCount++;
				}
			}

			int partCount = max - 1;
			int partLength = n - maxCount + 1;
			int emptySlots = partCount * partLength;
			int availableTasks = tasks.length - max * maxCount;
			int idles = Math.max(0, emptySlots - availableTasks);

			return tasks.length + idles;
		}
	}
}
