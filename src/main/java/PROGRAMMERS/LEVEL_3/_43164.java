package PROGRAMMERS.LEVEL_3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 여행경로
 */

public class _43164 {
    public static void main(String[] args) {
        Solution_43164 s = new Solution_43164();
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        for(String city : s.solution(tickets)) System.out.println(city);
    }
}

class Solution_43164{
    private String[][] tickets;
    private boolean[] use;
    private List<String> path;
    private Queue<String> pathCandidate;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        use = new boolean[tickets.length];
        path = new ArrayList<>();
        pathCandidate = new PriorityQueue<>();

        dfs("ICN");

        String pathString = pathCandidate.poll();

        assert pathString != null;
        String[] answer = new String[pathString.length() / 3];
        for(int i = 0 ; i < pathString.length() ; i += 3){
            answer[i / 3] = pathString.substring(i, i + 3);
        }

        return answer;
    }

    private void dfs(String departure){
        path.add(departure);

        if(path.size() == tickets.length + 1){
            StringBuilder pathString = new StringBuilder();
            for(String city : path) pathString.append(city);
            pathCandidate.add(pathString.toString());

            return;
        }

        for(int i = 0 ; i < tickets.length ; i++){
            if(!use[i] && departure.equals(tickets[i][0])){
                use[i] = true;
                dfs(tickets[i][1]);
                path.remove(path.size() - 1);
                use[i] = false;
            }
        }
    }
}
