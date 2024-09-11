package CodeTest.프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {

        더맵게Solution sol = new 더맵게Solution();

        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}

class 더맵게Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int num : scoville) {
            pQueue.add(num);
        }

        int now = -1;

        while(pQueue.peek() < K && pQueue.size() >= 2) {

            answer++;
            int least = pQueue.poll();
            int next = pQueue.poll();

            now = least + (next * 2);

            pQueue.add(now);
        }

        if(pQueue.peek() < K) {
            return -1;
        }

        return answer;
    }
}
