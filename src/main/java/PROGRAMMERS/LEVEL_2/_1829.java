package PROGRAMMERS.LEVEL_2;

/**
 * 카카오 프렌즈 컬러링북
 */

public class _1829 {
    public static void main(String[] args) {
        Solution_1829 s = new Solution_1829();
        int m = 6;
        int n = 4;
        int[][] pictures = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int[] answer = s.solution(m, n, pictures);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

class Solution_1829{
    private boolean[][] visited;
    private final int[][] dir = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    private int maxRow;
    private int maxCol;
    private int area = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        maxRow = m;
        maxCol = n;

        visited = new boolean[maxRow][maxCol];

        for(int r = 0 ; r < maxRow ; r++){
            for(int c = 0 ; c < maxCol ; c++){
                if(picture[r][c] > 0 && !visited[r][c]){
                    area = 0;
                    dfs(r, c, picture);

                    numberOfArea++;
                    if(area > maxSizeOfOneArea) maxSizeOfOneArea = area;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int r, int c, int[][] picture){
        visited[r][c] = true;
        area++;

        for(int[] d : dir) {
            if(
                r + d[0] >= 0 &&
                r + d[0] < maxRow &&
                c + d[1] >= 0 &&
                c + d[1] < maxCol &&
                !visited[r + d[0]][c + d[1]] &&
                picture[r][c] == picture[r+d[0]][c+d[1]]
            )  this.dfs(r + d[0], c + d[1], picture);
        }
    }
}
