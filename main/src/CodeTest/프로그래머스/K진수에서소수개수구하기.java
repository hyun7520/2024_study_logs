package CodeTest.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K진수에서소수개수구하기 {
    public static void main(String[] args) {

        K진수에서소수개수구하기Solution sol = new K진수에서소수개수구하기Solution();

        System.out.println(sol.solution(110011, 10));

    }
}

class K진수에서소수개수구하기Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String str = Integer.toString(n, k);
        String[] temp = str.split("0");

        for(String s : temp) {
            if(s.isEmpty()) continue;

            long num = Long.parseLong(s);

            if(checkPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean checkPrime(long num) {

        if(num == 1) return false;
        num = Long.parseLong(String.valueOf(num), 10);

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}