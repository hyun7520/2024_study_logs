package CodeTest.프로그래머스;

import java.util.Arrays;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {

        주식가격Solution sol = new 주식가격Solution();

        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
    }
}

class 주식가격Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}