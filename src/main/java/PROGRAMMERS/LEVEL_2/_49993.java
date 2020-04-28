package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;

/**
 * 스킬트리
 */

public class _49993 {
    public static void main(String[] args) {
        Solution_49993 s = new Solution_49993();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(s.solution(skill, skill_trees));
    }
}

class Solution_49993{
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            boolean result = isValid(skill, skill_tree);
            if (result) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isValid(String skill, String skill_tree){
        ArrayList<Integer> indexOfTree = new ArrayList<>();

        for(int i = 0 ; i < skill.length() ; i++){
            int idx = skill_tree.indexOf(skill.charAt(i));
            indexOfTree.add(idx);
        }

        // check valid

        int notMasterIdx = indexOfTree.indexOf(-1);
        if(notMasterIdx >= 0){
            // 배우지 않은 스킬 뒤로 찍은게 있는지 검사
            for(int i = notMasterIdx + 1; i < indexOfTree.size() ; i++){
                if(indexOfTree.get(i) >= 0){
                    return false;
                }
            }
        }
        else{
            notMasterIdx = indexOfTree.size();
        }

        // 찍은 스킬 순서 검사
        for(int i = 0 ; i < notMasterIdx - 1 ; i++){
            if(indexOfTree.get(i) > indexOfTree.get(i+1)){
                return false;
            }
        }

        return true;
    }
}
