package CodeTest;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {

        기능개발Solution sol = new 기능개발Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));

    }
}

class 기능개발Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> develop = new LinkedList<>();

        int days = 0;

        for(int i = 0; i < progresses.length; i++) {
            days = 100 - progresses[i];
            if(days % speeds[i] != 0) {
                develop.add(days/speeds[i] + 1);
            } else {
                develop.add(days/speeds[i]);
            }
        }

        int deploy = 1, now = develop.poll();
        List<Integer> list = new ArrayList<>();

        while(!develop.isEmpty()) {

            if(now >= develop.peek()) {
                deploy += 1;
                develop.poll();
            } else {
                list.add(deploy);
                deploy = 1;
                now = develop.poll();
            }
        }
        list.add(deploy);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}