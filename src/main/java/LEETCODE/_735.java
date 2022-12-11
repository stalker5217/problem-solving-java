package LEETCODE;

import java.util.Stack;

public class _735 {
	private static class Solution {
		public int[] asteroidCollision(int[] asteroids) {
			Stack<Integer> st = new Stack();

			for (int current : asteroids) {
				while (!st.isEmpty() && st.peek() > 0 && st.peek() < -current) {
					st.pop();
				}

				if (!st.isEmpty() && st.peek() > 0 && st.peek() == -current) {
					st.pop();
				} else if (st.isEmpty() || !(st.peek() > 0 && current < 0 && st.peek() > -current)) {
					st.push(current);
				}
			}

			return st.stream().mapToInt(c -> c).toArray();
		}
	}
}
