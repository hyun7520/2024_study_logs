package CodeTest.프로그래머스;

import java.util.*;

public class 숫자게임 {
    public static void main(String[] args) {

        숫자게임Solution sol = new 숫자게임Solution();

        System.out.println(sol.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));

    }
}

class 숫자게임Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int a : A) {
            aQueue.add(a);
        }

        Arrays.sort(B);
        Deque<Integer> bQueue = new LinkedList<>();
        for(int i = B.length - 1; i >= 0; i--) {
            bQueue.add(B[i]);
        }

        while(!aQueue.isEmpty()) {
            int aTeam = aQueue.poll();
            if(!bQueue.isEmpty() && bQueue.peek() > aTeam) {
                bQueue.poll();
                answer++;
            } else {
                bQueue.pollLast();
            }
        }

        return answer;
    }
}