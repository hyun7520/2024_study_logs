package CodeTest.카카오코테;

import java.util.Queue;
import java.util.LinkedList;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        int temp;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long q1Sum = getSum(queue1);
        long q2Sum = getSum(queue2);
        long qSum = q1Sum + q2Sum;

        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while(q1Sum != q2Sum) {

            if(answer > (queue1.length + queue2.length) * 2 ) {
                return - 1;
            }

            if(q1Sum > q2Sum) {
                temp = q1.poll();
                q1Sum -= temp;
                q2Sum += temp;
                q2.add(temp);
            }
            else if(q1Sum < q2Sum) {
                temp = q2.poll();
                q1Sum += temp;
                q2Sum -= temp;
                q1.add(temp);
            } else {
                return answer;
            }
            answer++;
        }

        return answer;
    }

    public long getSum(int[] arrays) {

        long sum = 0L;

        for(int num : arrays) {
            sum += (long) num;
        }
        return sum;
    }
}
