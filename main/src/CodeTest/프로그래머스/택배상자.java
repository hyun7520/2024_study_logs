package CodeTest.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {

        택배상자Solution sol = new 택배상자Solution();

        System.out.println(sol.solution(new int[] {5, 4, 3, 2, 1}));

    }
}

class 택배상자Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= order.length; i++) {
            stack.push(i);
            while(!stack.isEmpty()) {
                if(stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}