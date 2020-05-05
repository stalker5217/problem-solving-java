package PROGRAMMERS.LEVEL_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 */

public class _42583 {
    public static void main(String[] args) {
        Solution_42583 s = new Solution_42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(s.solution(bridge_length, weight, truck_weights));
    }
}

class Solution_42583{
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckList = new LinkedList<>();
        for (int truck_weight : truck_weights) truckList.add(truck_weight);

        // 처음 한 대는 무조건 올라 가서 시작
        Queue<Truck> ingList = new LinkedList<>();
        ingList.add(new Truck(truckList.poll(), 1));
        int time = 1;
        assert ingList.peek() != null;
        int curWeight = ingList.peek().weight;
        
        while(!ingList.isEmpty()) {
            time++;
            
            // 도착 트럭 검사
            if (time - ingList.peek().inTime >= bridge_length) {
                Truck arriveTruck = ingList.poll();
                curWeight -= arriveTruck.weight;
            }
            // 새로운 트럭 추가 검사
            if (!truckList.isEmpty() && curWeight + truckList.peek() <= weight) {
                int newTruckWeight = truckList.poll();
                curWeight += newTruckWeight;
                ingList.add(new Truck(newTruckWeight, time));
            }
            // 무게 때문에 더 이상 삽입 불가능 할 때 시간 점프
            else if(!ingList.isEmpty()){
                time = ingList.peek().inTime + bridge_length - 1;
            }
        }

        return time;
    }
}

class Truck{
    public int weight; // 무게
    public int inTime; // 진입 시간

    public Truck(int weight, int inTime){
        this.weight = weight;
        this.inTime = inTime;
    }
}
