package PROGRAMMERS.LEVEL_2;

/**
 * [3차] 방금그곡
 */

public class _17683 {
    public static void main(String[] args) {
        Solution_17683 s = new Solution_17683();
        String m = "s";
        String[] musicInfos = {
                "03:00,03:30,FOO,CC#B",
                "04:00,04:08,BAR,CC#BCC#BCC#B"
        };
        System.out.println(s.solution(m, musicInfos));
    }
}

class Solution_17683{
    public String solution(String m, String[] musicInfos) {
        String ret = "(None)";
        int retPlayTime = -1;

        for(String info : musicInfos){
            // start time, end time, name, sheet
            String[] infoArr = info.split(",");

            m = replaceSharp(m);
            String start = infoArr[0];
            String end = infoArr[1];
            String name = infoArr[2];
            String sheet = replaceSharp(infoArr[3]);

            StringBuilder playMusic = new StringBuilder();
            int playTime = getPlayTime(start, end);
            playMusic.append(sheet.repeat(playTime / sheet.length()));
            playMusic.append(sheet, 0, playTime % sheet.length());

            if(playMusic.indexOf(m) >= 0 && retPlayTime < playTime){
                ret = name;
                retPlayTime = playTime;
            }
        }

        return ret;
    }

    private String replaceSharp(String input){
        return input
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    private int getPlayTime(String start, String end){
        String[] start_hour_min = start.split(":");
        String[] end_hour_min = end.split(":");

        int start_hour = Integer.parseInt(start_hour_min[0]);
        int start_min = Integer.parseInt(start_hour_min[1]);
        int end_hour = Integer.parseInt(end_hour_min[0]);
        int end_min = Integer.parseInt(end_hour_min[1]);

        return (end_hour - start_hour) * 60 + (end_min - start_min);
    }
}
