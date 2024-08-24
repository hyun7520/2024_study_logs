package CodeTest;

import java.util.Arrays;
import java.util.Stack;

public class 기능개발 {

    public void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> maxDays = new Stack<>();
        Stack<Integer> deploy = new Stack<>();

        int days = 0;

        for(int i = 0; i < progresses.length; i++) {
            days = 100 - progresses[i];
            if(days % speeds[i] != 0) {
                maxDays.push(days/speeds[i] + 1);
            } else {
                maxDays.push(days/speeds[i]);
            }
        }

        int deploys = 0;

        while(!maxDays.isEmpty()) {

            int now = maxDays.pop();
            int next = maxDays.peek();

            if(now > next) {

            } else if(now < next || now == next) {

            }

        }

        return answer;
    }
}
