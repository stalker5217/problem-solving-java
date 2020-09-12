package PROGRAMMERS.LEVEL_3;

import java.util.*;

/**
 * [1차] 셔틀버스
 */

public class _17678 {
    public static void main(String[] args) {
        Solution_17678 s = new Solution_17678();
        int n = 2, t = 10, m = 2;
        String[] timetable = {
                "09:10",
                "09:09",
                "08:00"
        };
        System.out.println(s.solution(n, t, m, timetable));
    }
}

class Solution_17678{
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> waitPerson = new PriorityQueue<>();
        for(String time : timetable) waitPerson.add(changeStringToMinute(time));
        
        // 앞에 보낼 사람 다 보냄
        for(int busNumber = 0 ; busNumber < n - 1 ; busNumber++){
            int curBusTime = changeStringToMinute("09:00") + busNumber * t;
            int coverage = m;
            while(coverage > 0 && !waitPerson.isEmpty() && waitPerson.peek() <= curBusTime){
                waitPerson.poll();
                --coverage;
            }
        }

        String answer;
        int lastBusTime = changeStringToMinute("09:00") + (n-1) * t;
        int lastBoardingTime = 0;
        int coverage = m;
        while(coverage > 0 && !waitPerson.isEmpty() && waitPerson.peek() <= lastBusTime){
            lastBoardingTime = waitPerson.poll();
            --coverage;
        }

        // 막차에 자리가 남아 있다면
        if(coverage > 0) answer = changeMinuteToString(lastBusTime);
        // 막차에 자리가 없으면 마지막 놈보다 1분 빨리
        else answer = changeMinuteToString(lastBoardingTime - 1);

        return answer;
    }

    private int changeStringToMinute(String time){
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);

        return hour * 60 + minute;
    }

    private String changeMinuteToString(int timeStamp){
        int hour = timeStamp / 60;
        int minute = timeStamp % 60;

        StringBuilder ret = new StringBuilder();
        if(hour < 10) ret.append(0);
        ret.append(hour);

        ret.append(":");

        if(minute < 10) ret.append("0");
        ret.append(minute);

        return ret.toString();
    }
}
