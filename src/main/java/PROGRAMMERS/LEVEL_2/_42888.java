package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방
 */

public class _42888 {
    public static void main(String[] args) {
        Solution_42888 s = new Solution_42888();
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        for(String log : s.solution(record)){
            System.out.println(log);
        }
    }
}

class Solution_42888{
    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        List<Log> logList = new ArrayList<>();

        for(String r : record){
            String[] splitArr = r.split(" ");
            String cmd = splitArr[0];
            String id = splitArr[1];

            switch (cmd) {
                case "Enter":
                    nameMap.put(id, splitArr[2]);
                    logList.add(new Log(Log.in, id));
                    break;
                case "Leave":
                    logList.add(new Log(Log.out, id));
                    break;
                case "Change":
                    nameMap.put(id, splitArr[2]);
                    break;
            }
        }

        List<String> retList = new ArrayList<>();
        logList.forEach(l -> {
            String ret = nameMap.get(l.id);
            if(l.action == Log.in) ret += "님이 들어왔습니다.";
            else if(l.action == Log.out) ret += "님이 나갔습니다.";
            retList.add(ret);
        });

        return retList.toArray(new String[0]);
    }
}

class Log{
    public static final int in = 0;
    public static final int out = 1;
    public int action;
    public String id;

    public Log(int action, String id){
        this.action = action;
        this.id = id;
    }
}
