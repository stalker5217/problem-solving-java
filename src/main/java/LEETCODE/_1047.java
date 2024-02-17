package LEETCODE;

import java.util.Deque;
import java.util.LinkedList;

public class _1047 {
    private static class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);

                boolean isDuplicated = !deque.isEmpty() && deque.peek() == current;
                if (isDuplicated) {
                    while (!deque.isEmpty() && deque.peek() == current) {
                        deque.poll();
                    }
                } else {
                    deque.push(current);
                }
            }

            StringBuilder result = new StringBuilder();
            while (!deque.isEmpty()) {
                result.append(deque.pollLast());
            }

            return result.toString();
        }
    }
}
