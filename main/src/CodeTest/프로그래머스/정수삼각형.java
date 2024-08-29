package CodeTest.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 정수삼각형 {
    public static void main(String[] args) {

        정수삼각형DPSolution sol = new 정수삼각형DPSolution();

        System.out.println(sol.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));

    }
}

// 시간 초과
class 정수삼각형DFSSolution {

    int total = 0;

    public int solution(int[][] triangle) {

        return DFS(1, triangle, triangle[0][0], 0);
    }

    public int DFS(int depth, int[][] triangle, int now, int index) {

        if(depth == triangle.length) {
            total = Math.max(total, now);
        } else {
            DFS(depth + 1, triangle, now + triangle[depth][index], index);
            DFS(depth + 1, triangle, now + triangle[depth][index + 1], index + 1);
        }
        return total;
    }
}

class 정수삼각형DPSolution {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }

            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for(int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }
}