package PROGRAMMERS.LEVEL_2;

public class _49994 {
    public static void main(String[] args) {
        Solution_49994 s = new Solution_49994();
        System.out.println(s.solution("LULLLLLLU"));
    }
}

class Solution_49994 {
    private int answer = 0;
    private final boolean[][][] isMoved = new boolean[11][11][4];
    private int r = 5, c = 5;

    public int solution(String dirs) {
        for(int i = 0 ; i < dirs.length() ; i++){
            switch(dirs.charAt(i)){
                case 'L': move(0, 0, -1); break;
                case 'R': move(1, 0, 1); break;
                case 'U': move(2, 1, 0); break;
                case 'D': move(3, -1, 0); break;
            }
        }

        return answer;
    }

    private void move(int dir, int r_move, int c_move){
        if(r + r_move < 0 || r + r_move > 10 || c + c_move < 0 || c + c_move > 10) return;

        if(!isMoved[r][c][dir]) {
            isMoved[r][c][dir] = true;

            if(dir == 0) dir = 1;
            else if(dir == 1) dir = 0;
            else if(dir == 2) dir = 3;
            else if(dir == 3) dir = 2;
            if(!isMoved[r + r_move][c + c_move][dir]) answer++;
        }

        r+=r_move;
        c+=c_move;
    }
}
