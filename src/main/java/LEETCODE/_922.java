package LEETCODE;

public class _922 {
    private static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int evenIndex = 0;
            int oddIndex = 1;

            while (evenIndex < nums.length || oddIndex < nums.length) {
                while (evenIndex < nums.length && nums[evenIndex] % 2 == 0) {
                    evenIndex += 2;
                }

                while (oddIndex < nums.length && nums[oddIndex] % 2 == 1) {
                    oddIndex += 2;
                }

                if (evenIndex < nums.length && oddIndex < nums.length) {
                    int temp = nums[evenIndex];
                    nums[evenIndex] = nums[oddIndex];
                    nums[oddIndex] = temp;
                }
            }

            return nums;
        }
    }
}
