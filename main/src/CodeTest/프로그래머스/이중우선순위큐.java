package CodeTest.프로그래머스;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {

        이중우선순위큐Solution sol = new 이중우선순위큐Solution();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(sol.solution(operations)));

    }
}

class 이중우선순위큐Solution {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        String[] operation;
        int number;

        for(String str: operations) {
            operation = str.split(" ");
            number = Integer.parseInt(operation[1]);

            if(operation[0].equals("I")) {
                min.add(number);
                max.add(number);
                continue;
            }
            if(operation[0].equals("D") && !min.isEmpty()) {
                if(number == 1) {
                    int del = max.poll();
                    min.remove(del);
                } else if(number == -1) {
                    int del = min.poll();
                    max.remove(del);
                }
            }
        }

        if(min.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }

        return answer;
    }
}