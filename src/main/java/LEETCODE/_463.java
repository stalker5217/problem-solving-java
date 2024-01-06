package LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class _463 {
    private static class Solution {
        private final Pair[] directions = {
                new Pair(-1, 0),
                new Pair(1, 0),
                new Pair(0, -1),
                new Pair(0, 1)
        };

        public int islandPerimeter(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return calculate(i, j, grid);
                    }
                }
            }

            return 0;
        }

        private int calculate(int i, int j, int[][] grid) {
            int perimeter = 0;
            boolean[][] visit = new boolean[grid.length][grid[0].length];

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(i, j));
            visit[i][j] = true;

            while (!q.isEmpty()) {
                Pair current = q.poll();
                System.out.println(perimeter);
                for (Pair dir : directions) {
                    int nextX = current.x + dir.x;
                    int nextY = current.y + dir.y;

                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[nextX].length) {
                        perimeter++;
                        continue;
                    }

                    if (grid[nextX][nextY] == 0) {
                        perimeter++;
                        continue;
                    }

                    if (visit[nextX][nextY]) {
                        continue;
                    }

                    q.add(new Pair(nextX, nextY));
                    visit[nextX][nextY] = true;
                }
            }

            return perimeter;
        }

        private static class Pair {
            final int x;
            final int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
