package LEETCODE;

public class _74 {
	private static class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			int rowStart = 0;
			int rowEnd = matrix.length -1;

			while (rowStart <= rowEnd) {
				int mid = (rowStart + rowEnd) / 2;

				if (matrix[mid][0] > target) {
					rowEnd = mid - 1;
				} else {
					rowStart = mid + 1;
				}
			}

			int targetRow = rowEnd;

			if (targetRow < 0) {
				return false;
			}

			int colStart = 0;
			int colEnd = matrix[targetRow].length - 1;
			while (colStart <= colEnd) {
				int mid = (colStart + colEnd) / 2;

				if (matrix[targetRow][mid] == target) {
					return true;
				} else if (matrix[targetRow][mid] > target) {
					colEnd = mid - 1;
				} else {
					colStart = mid + 1;
				}
			}

			return false;
		}
	}
}
