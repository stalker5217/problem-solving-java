package PROGRAMMERS.LEVEL_3;

/**
 * 단어 변환
 */

public class _43163 {
    public static void main(String[] args) {
        Solution_43163 s = new Solution_43163();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(s.solution(begin, target, words));
    }
}

class Solution_43163{
    private String target;
    private String[] words;
    private boolean[] visit;

    private int answer;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = new String[words.length];
        visit = new boolean[words.length];
        System.arraycopy(words, 0, this.words, 0, words.length);
        answer = 987654321;
        bfs(0, begin);

        return answer == 987654321 ? 0 : answer;
    }

    private void bfs(int cnt, String cur){

        if(cur.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0 ; i < words.length ; i++){
            if(!visit[i] && compareWord(cur, words[i]) == 1){
                visit[i] = true;
                bfs(cnt + 1, words[i]);
                visit[i] = false;
            }
        }

    }

    private int compareWord(String a, String b){
        int size = a.length();
        int diffCnt = 0;
        for(int i = 0 ; i < size ; i++){
            if(a.charAt(i) != b.charAt(i)){
                diffCnt++;
            }
        }

        return diffCnt;
    }
}
