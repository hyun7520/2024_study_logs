package CodeTest.프로그래머스;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {

        야근지수Solution sol = new 야근지수Solution();

        System.out.println(sol.solution(4, new int[]{4, 3, 3}));

    }
}

class 야근지수Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int count = n;

        int sum = Arrays.stream(works).sum();
        if(sum <= n) return answer;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.add(work);
        }

        while(count != 0) {
            int now = queue.poll();
            now--;
            count--;
            queue.add(now);
        }

        for(int i : queue) {
            answer += (long) i * i;
        }


        return answer;
    }
}
