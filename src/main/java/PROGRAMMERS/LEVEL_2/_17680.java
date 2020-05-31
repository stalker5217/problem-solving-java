package PROGRAMMERS.LEVEL_2;

import java.util.LinkedList;
import java.util.List;

/**
 * [1차] 캐시
 */

public class _17680 {
    public static void main(String[] args) {
        Solution_17680 s = new Solution_17680();
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(s.solution(cacheSize, cities));
    }
}

class Solution_17680{
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> cache = new LinkedList<>();
        for(String pure_city : cities){
            String city = pure_city.toLowerCase();
            // cache hit
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                time++;
            }
            else {
                if (cache.size() < cacheSize) {
                    cache.add(city);
                } else if (cacheSize > 0) {
                    cache.remove(0);
                    cache.add(city);
                }
                time+=5;
            }
        }

        return time;
    }
}