package LEETCODE;

import java.util.Deque;
import java.util.LinkedList;

public class _682 {
    private static class Solution {
        public int calPoints(String[] operations) {
            Deque<Integer> stack = new LinkedList<>();
            for (String operation : operations) {
                if ("C".equals(operation)) {
                    stack.pop();
                } else if ("D".equals(operation)) {
                    int score = stack.pop();

                    stack.push(score);
                    stack.push(score * 2);
                } else if ("+".equals(operation)) {
                    int score1 = stack.pop();
                    int score2 = stack.pop();

                    stack.push(score2);
                    stack.push(score1);
                    stack.push(score1 + score2);
                } else {
                    int score = Integer.parseInt(operation);
                    stack.push(score);
                }
            }

            return stack.stream().mapToInt(c -> c).sum();
        }
    }
}
