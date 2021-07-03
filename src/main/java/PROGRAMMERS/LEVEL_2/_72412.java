package PROGRAMMERS.LEVEL_2;

import java.util.*;

public class _72412 {
    public static void main(String[] args) {
        Solution_72412 s = new Solution_72412();

        String info[] = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String query[] = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        for(int result : s.solution(info, query)) System.out.print(result + " ");
    }
}

class Solution_72412 {
    private static final String language[] = {"-", "python", "java", "cpp"};
    private static final String position[] = {"-", "backend", "frontend"};
    private static final String grade[] = {"-", "junior", "senior"};
    private static final String food[] = {"-", "chicken", "pizza"};

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infoMap = new HashMap<>();

        for(int i = 0 ; i < language.length ; i++) {
            for(int j = 0 ; j < position.length ; j++) {
                for(int k = 0 ; k < grade.length ; k++) {
                    for(int l = 0 ; l < food.length ; l++) {
                        String result = language[i] + position[j] + grade[k] + food[l];
                        infoMap.put(result, new ArrayList<>());
                    }
                }
            }
        }

        for(String person : info) {
            String[] personArr = person.split(" ");
            int score = Integer.parseInt(personArr[4]);

            infoMap.get(personArr[0] + personArr[1] + personArr[2] + personArr[3]).add(score);

            infoMap.get("-" + personArr[1] + personArr[2] + personArr[3]).add(score);
            infoMap.get(personArr[0] + "-" + personArr[2] + personArr[3]).add(score);
            infoMap.get(personArr[0] + personArr[1] + "-" + personArr[3]).add(score);
            infoMap.get(personArr[0] + personArr[1] + personArr[2] + "-").add(score);

            infoMap.get("--" + personArr[2] + personArr[3]).add(score);
            infoMap.get("-" + personArr[1] + "-" + personArr[3]).add(score);
            infoMap.get("-" + personArr[1] + personArr[2] + "-").add(score);
            infoMap.get(personArr[0] + "--" + personArr[3]).add(score);
            infoMap.get(personArr[0] + "-" + personArr[2] + "-").add(score);
            infoMap.get(personArr[0] + personArr[1] + "--").add(score);

            infoMap.get("---" + personArr[3]).add(score);
            infoMap.get("-" + personArr[1] + "--").add(score);
            infoMap.get("--" + personArr[2] + "-").add(score);
            infoMap.get(personArr[0] + "---").add(score);

            infoMap.get("----").add(score);
        }

        for(String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }

        int result[] = new int[query.length];
        for(int i = 0 ; i < query.length ; i++) {
            String[] queryArr = query[i].split(" ");
            String key = queryArr[0] + queryArr[2] + queryArr[4] + queryArr[6];
            int baseScore = Integer.parseInt(queryArr[7]);

            List<Integer> scoreList = infoMap.get(key);

            int start = 0;
            int end = scoreList.size();

            while(start < end) {
                int middle = (start + end) / 2;
                if(scoreList.get(middle) < baseScore) start = middle + 1;
                else end = middle;
            }

            result[i] = scoreList.size() - end;
        }

        return result;
    }
}