package PROGRAMMERS.LEVEL_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _42579 {
    public static void main(String[] args) {
        Solution_42579 s = new Solution_42579();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        for(int idx : s.solution(genres, plays)){
            System.out.print(idx + " ");
        }
    }
}

class Solution_42579{
    public int[] solution(String[] genres, int[] plays) {
        List<Music> musicList = new ArrayList<>();

        for(int i = 0 ; i < genres.length ; i++){
            musicList.add(new Music(genres[i], plays[i]));
            Music.genreTotalPlay.merge(genres[i], plays[i], Integer::sum);
        }

        musicList = musicList
                .stream()
                .sorted((m1, m2) -> {
                    if(Music.genreTotalPlay.get(m1.getGenres()) < Music.genreTotalPlay.get(m2.getGenres())) return 1;
                    else if(Music.genreTotalPlay.get(m1.getGenres()) > Music.genreTotalPlay.get(m2.getGenres())) return -1;
                    else return Integer.compare(m2.getPlay(), m1.getPlay());
                })
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        String curGenre = musicList.get(0).getGenres();
        int cnt = 0;
        for(Music m : musicList){
            if(!m.getGenres().equals(curGenre)){
                curGenre = m.getGenres();
                cnt = 0;
            }

            if(cnt < 2){
                answer.add(m.getIdx());
                cnt++;
            }
        }

        return answer.stream().mapToInt(c->c).toArray();
    }
}

class Music{
    public static Map<String, Integer> genreTotalPlay = new HashMap<>();
    public static int idxCnt = 0;

    private final int idx;
    private final String genres;
    private final int play;

    public Music(String genres, int play){
        idx = idxCnt++;
        this.genres = genres;
        this.play = play;
    }

    public int getIdx(){
        return idx;
    }

    public String getGenres(){
        return genres;
    }

    public int getPlay(){
        return play;
    }
}