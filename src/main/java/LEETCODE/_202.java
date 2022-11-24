package LEETCODE;

import java.util.HashSet;
import java.util.Set;

public class _202 {
	private static class Solution {
		public boolean isHappy(int n) {

			Set<Integer> doneSet = new HashSet<>();
			while (!doneSet.contains(n)) {
				doneSet.add(n);

				int sum = 0;
				while (n > 0) {
					int temp = n % 10;
					sum += temp * temp;
					n /= 10;
				}

				n = sum;
			}


			return doneSet.contains(1);
		}
	}
}
