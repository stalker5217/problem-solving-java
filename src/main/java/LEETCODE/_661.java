package LEETCODE;

public class _661 {
    private static class Solution {
        public int[][] imageSmoother(int[][] img) {
            int m = img.length;
            int n = img[0].length;
            int[][] result = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;
                    int sum = 0;
                    int startRowBound = Math.max(i - 1, 0);
                    int endRowBound = Math.min(i + 2, m);
                    int startColBound = Math.max(j - 1, 0);
                    int endColBound = Math.min(j + 2, n);
                    for (int a = startRowBound; a < endRowBound; a++) {
                        for (int b = startColBound; b < endColBound; b++) {
                            count++;
                            sum += img[a][b];
                        }
                    }
                    result[i][j] = sum / count;
                }
            }

            return result;
        }
    }
}
