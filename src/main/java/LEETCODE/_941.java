package LEETCODE;

public class _941 {
    private static class Solution {
        public boolean validMountainArray(int[] arr) {
            int maxValue = -1;
            int maxValueIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                    maxValueIndex = i;
                }
            }

            if (maxValueIndex == 0 || maxValueIndex == arr.length - 1) {
                return false;
            }

            for (int i = 0; i < maxValueIndex; i++) {
                if (arr[i] >= arr[i + 1]) {
                    return false;
                }
            }

            for (int i = maxValueIndex; i < arr.length - 1; i++) {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }

            return true;
        }
    }
}
