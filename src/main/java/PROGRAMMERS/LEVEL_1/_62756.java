package PROGRAMMERS.LEVEL_1;

/**
 * [카카오 인턴] 키패드 누르기
 */

public class _62756 {
    public static void main(String[] args) {
        Solution_62756 s = new Solution_62756();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(s.solution(numbers, hand));
    }
}

class Solution_62756{
    public String solution(int[] numbers, String hand) {
        Position leftHandPos = new Position(3, 0);
        Position rightHandPos = new Position(3, 2);

        StringBuilder answer = new StringBuilder();

        for(int target : numbers){
            if(target == 1 || target == 4 || target == 7){
                leftHandPos.r = (target - 1) / 3;
                leftHandPos.c = (target - 1) % 3;
                answer.append('L');
            }
            else if(target == 3 || target == 6 || target == 9){
                rightHandPos.r = (target - 1) / 3;
                rightHandPos.c = (target - 1) % 3;
                answer.append('R');
            }
            else{
                if(target == 0) target = 11;

                int distFromLeft = getDistance(target, leftHandPos);
                int distFromRight = getDistance(target, rightHandPos);

                if(distFromLeft < distFromRight){
                    leftHandPos.r = (target - 1) / 3;
                    leftHandPos.c = (target - 1) % 3;
                    answer.append('L');
                }
                else if(distFromLeft > distFromRight){
                    rightHandPos.r = (target - 1) / 3;
                    rightHandPos.c = (target - 1) % 3;
                    answer.append('R');
                }
                else if(hand.compareTo("left") == 0){
                    leftHandPos.r = (target - 1) / 3;
                    leftHandPos.c = (target - 1) % 3;
                    answer.append('L');
                }
                else{
                    rightHandPos.r = (target - 1) / 3;
                    rightHandPos.c = (target - 1) % 3;
                    answer.append('R');
                }
            }
        }

        return answer.toString();
    }

    public int getDistance(int target, Position from){
        int targetR = (target - 1) / 3;
        int targetC = (target - 1) % 3;

        return Math.abs(targetR - from.r) + Math.abs(targetC - from.c);
    }
}

class Position{
    public int r;
    public int c;

    public Position(int r, int c){
        this.r = r;
        this.c = c;
    }
}