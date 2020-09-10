package PROGRAMMERS.LEVEL_3;

import java.util.*;

/**
 * 길 찾기 게임
 */

public class _42892 {
    public static void main(String[] args) {
        Solution_42892 s = new Solution_42892();
        int[][] nodeinfo = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };
        for(int[] visit : s.solution(nodeinfo)){
            for(int node : visit) System.out.print(node + " ");
            System.out.println();
        }
    }
}

class Solution_42892{
    public int[][] solution(int[][] nodeinfo) {
        List<Pos> posList = new ArrayList<>();

        // Transfer to Collection
        for(int i = 0 ; i < nodeinfo.length ; i++)
            posList.add(new Pos(i+1, nodeinfo[i][0],nodeinfo[i][1]));

        // X좌표 기준 Sort
        posList.sort(Comparator.comparingInt(p -> p.x));

        TreeNode root = makeTree(posList, 0, posList.size());

        List<Integer> preOrderResult = new ArrayList<>();
        List<Integer> postOrderResult = new ArrayList<>();

        assert root != null;
        preOrder(root, preOrderResult);
        postOrder(root, postOrderResult);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderResult.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderResult.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private TreeNode makeTree(List<Pos> posList, int startIdx, int endIdx){
        // escape condition
        if(startIdx >= endIdx) return null;

        // Map (Y value : cnt)
        Map<Integer, Integer> yCnt = new HashMap<>();
        for(int i = startIdx ; i < endIdx ; i++){
            int cnt = yCnt.getOrDefault(posList.get(i).y, 0);
            yCnt.put(posList.get(i).y, cnt);
        }

        // 동일한 값이 없으며, 가장 큰 Y값을 가진 인덱스
        int targetIdx = -1;
        int maxValue = -1;
        for(int i = startIdx ; i < endIdx ; i++){
            int cnt = yCnt.get(posList.get(i).y);
            if(cnt > 1) continue;

            if(maxValue < posList.get(i).y){
                targetIdx = i;
                maxValue = posList.get(i).y;
            }
        }

        TreeNode cur = new TreeNode(posList.get(targetIdx).number);
        cur.left = makeTree(posList, startIdx, targetIdx);
        cur.right = makeTree(posList, targetIdx + 1, endIdx);

        return cur;
    }

    private void preOrder(TreeNode curNode, List<Integer> preOrderResult){
        preOrderResult.add(curNode.value);
        if(curNode.left != null) preOrder(curNode.left, preOrderResult);
        if(curNode.right != null) preOrder(curNode.right, preOrderResult);
    }

    private void postOrder(TreeNode curNode, List<Integer> postOrderResult){
        if(curNode.left != null) postOrder(curNode.left, postOrderResult);
        if(curNode.right != null) postOrder(curNode.right, postOrderResult);
        postOrderResult.add(curNode.value);
    }
}

class Pos{
    public int number;
    public int x;
    public int y;

    public Pos(int number, int x, int y){
        this.number = number;
        this.x = x;
        this.y = y;
    }
}

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }
}