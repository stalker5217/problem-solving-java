package LEETCODE;

public class _605 {
    private static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1
                        || (i > 0 && flowerbed[i - 1] == 1)
                        || (i + 1 < flowerbed.length && flowerbed[i + 1] == 1)
                ) {
                    continue;
                }

                flowerbed[i] = 1;
                n--;
            }

            return n <= 0;
        }
    }
}
