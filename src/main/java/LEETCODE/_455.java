package LEETCODE;

import java.util.Arrays;

public class _455 {
    private final class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int satisfyCount = 0;
            int childIndex = 0;
            int cookieIndex = 0;
            while (cookieIndex < s.length && childIndex < g.length) {
                if (g[childIndex] <= s[cookieIndex++]) {
                    satisfyCount++;
                    childIndex++;
                }
            }

            return satisfyCount;
        }
    }
}
