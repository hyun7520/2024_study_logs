package CodeTest.프로그래머스;

import java.util.*;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {

        뒤에있는큰수찾기Solution sol = new 뒤에있는큰수찾기Solution();

        System.out.println(Arrays.toString(sol.solution(new int[]{9, 1, 5, 3, 6, 2})));

    }
}

class 뒤에있는큰수찾기Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i = 1; i < numbers.length; i++) {

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}

// 시간 초과
class 뒤에있는큰수찾기SolutionTimeOut {
    public int[] solution(int[] numbers) {

        for(int i = 0; i < numbers.length - 1; i++) {

            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[j] > numbers[i]) {
                    numbers[i] = numbers[j];
                    break;
                }
                if(j == numbers.length - 1) {
                    numbers[i] = -1;
                }
            }
        }

        numbers[numbers.length - 1] = -1;

        return numbers;
    }
}