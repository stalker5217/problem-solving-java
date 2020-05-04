package PROGRAMMERS.LEVEL_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프린터
 */

public class _42587 {
    public static void main(String[] args) {
        Solution_42587 s = new Solution_42587();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(s.solution(priorities, location));
    }
}

class Solution_42587{
    public int solution(int[] priorities, int location) {
        class Document{
            public final int loc;
            public final int priority;

            public Document(int loc, int priority){
                this.loc = loc;
                this.priority = priority;
            }
        }

        Queue<Document> docQueue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < priorities.length ; i++){
            Document d = new Document(i, priorities[i]);
            docQueue.add(d);
            pq.add(priorities[i]);
        }

        int removeCnt = 0;
        while(!docQueue.isEmpty()){
            Document cur = docQueue.peek();
            if(pq.peek() != null && cur.priority == pq.peek()){
                removeCnt++;
                if(cur.loc == location){
                    break;
                }
                else{
                    docQueue.remove();
                    pq.remove();
                }
            }

            else{
                docQueue.remove();
                docQueue.add(cur);
            }
        }

        return removeCnt;
    }
}
